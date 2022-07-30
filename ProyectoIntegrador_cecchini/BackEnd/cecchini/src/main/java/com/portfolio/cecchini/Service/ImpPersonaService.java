package com.portfolio.cecchini.Service;

import com.portfolio.cecchini.Entity.Persona;
import com.portfolio.cecchini.Interface.IPersonaService;
import com.portfolio.cecchini.Repository.IPersonaRepository;
import java.io.Serializable;
import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired 
    IPersonaRepository ipersonaRepository;

    // override trae los metodos de la clase
    // listar personas
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    // guardar persona
    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    //borrar persona
    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }
    
    // buscar persona
    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public Persona findPersona(SingularAttribute<AbstractPersistable, Serializable> id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   }

