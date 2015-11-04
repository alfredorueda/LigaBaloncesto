package demo.Controller;

import demo.Exception.EquipoException;
import demo.Model.Equipo;
import demo.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Olga on 03/11/2015.
 */

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo save(@RequestBody Equipo equipo){

        return equipoRepository.save(equipo);
    }

    //Devuelve todos los equipos
    @RequestMapping(method = RequestMethod.GET)
    public List<Equipo>findAll(){
        List<Equipo> equipos = new ArrayList<Equipo>();
        Iterator<Equipo> iterator = equipoRepository.findAll().iterator();
        while(iterator.hasNext()){
            equipos.add(iterator.next());
        }
        return equipos;
    }

    //Devuelve un equipo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Equipo findById(@PathVariable Long id) {
        Equipo equipo = equipoRepository.findOne(id);

        if (equipo == null) {
            throw new EquipoException("El equipo con " + id + " no existe");
        }
        return equipo;
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        Equipo equipo = equipoRepository.findOne(id);

        if (equipo == null){throw new EquipoException("El equipo con " + id + " no existe");
        }

        equipoRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Equipo updateById(@PathVariable Long id,@RequestBody Equipo equipo){
        Equipo equipo1=equipoRepository.findOne(id);

        if(equipo1 == null){throw new EquipoException("El equipo con " + id + " no existe");}

        return equipoRepository.save(equipo);
    }
}
