
package com.portfolio.cecchini.Interface;

import com.portfolio.cecchini.Entity.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;


public interface IPersonaService {
    //traer persona
    public List <Persona> getPersona();
     
    //guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto pero lo buscamos por id
    public void deletePersona (Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);

    public Persona findPersona(SingularAttribute<AbstractPersistable, Serializable> id);
}
