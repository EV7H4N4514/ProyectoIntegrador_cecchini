package com.portfolio.cecchini.Controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import com.portfolio.cecchini.Dto.dtoExperiencia;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.portfolio.cecchini.Security.Controller.Mensaje;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import com.portfolio.cecchini.Entity.Experiencia;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.portfolio.cecchini.Service.SExperiencia;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/explab" })
@CrossOrigin(origins = { "http://localhost:4200" })
public class CExperiencia
{
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping({ "/lista" })
    public ResponseEntity<List<Experiencia>> list() {
        final List<Experiencia> list = (List<Experiencia>)this.sExperiencia.list();
        return (ResponseEntity<List<Experiencia>>)new ResponseEntity((Object)list, HttpStatus.OK);
    }
    
    @GetMapping({ "/detail/{id}" })
    public ResponseEntity<Experiencia> getById(@PathVariable("id") final int id) {
        if (!this.sExperiencia.existById(id)) {
            return (ResponseEntity<Experiencia>)new ResponseEntity((Object)new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        final Experiencia experiencia = this.sExperiencia.getOne(id).get();
        return (ResponseEntity<Experiencia>)new ResponseEntity((Object)experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping({ "/delete/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") final int id) {
        if (!this.sExperiencia.existById(id)) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        this.sExperiencia.delete(id);
        return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping({ "/create" })
    public ResponseEntity<?> create(@RequestBody final dtoExperiencia dtoexp) {
        if (StringUtils.isBlank((CharSequence)dtoexp.getNombreE())) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (this.sExperiencia.existByNombreE(dtoexp.getNombreE())) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        final Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        this.sExperiencia.save(experiencia);
        return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping({ "/update/{id}" })
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final dtoExperiencia dtoexp) {
        if (!this.sExperiencia.existById(id)) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (this.sExperiencia.existByNombreE(dtoexp.getNombreE()) && this.sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank((CharSequence)dtoexp.getNombreE())) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        final Experiencia experiencia = this.sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        this.sExperiencia.save(experiencia);
        return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
