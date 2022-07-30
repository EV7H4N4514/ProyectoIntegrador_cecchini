package com.portfolio.cecchini.Controller;

import com.portfolio.cecchini.Dto.dtoSkills;
import com.portfolio.cecchini.Entity.Skills;
import com.portfolio.cecchini.Security.Controller.Mensaje;
import com.portfolio.cecchini.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200" )
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills,HttpStatus.OK);
    }
    
    @PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
		if(StringUtils.isBlank(dtoskills.getNombreSk()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(sSkills.existsByNombreSk(dtoskills.getNombreSk()))
			return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);

		Skills skills = new Skills(dtoskills.getNombreSk(),
				dtoskills.getPorcentaje(),
				dtoskills.getImgSkills());
		sSkills.save(skills);

		return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
		//Validamos si existe el ID
		if(!sSkills.existsById(id))
			return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		//Compara nombre de skill
		if(sSkills.existsByNombreSk(dtoskills.getNombreSk()) &&
				sSkills.getByNombreSk(dtoskills.getNombreSk()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
		//No puede estar vacio
		if(StringUtils.isBlank(dtoskills.getNombreSk()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Skills skills = sSkills.getOne(id).get();
		skills.setNombreSk(dtoskills.getNombreSk());
		skills.setPorcentaje(dtoskills.getPorcentaje());
		skills.setImgSkills(dtoskills.getImgSkills());

		sSkills.save(skills);
		return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
        
        
}

