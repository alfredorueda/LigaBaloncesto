package demo.Controller;

import demo.Exception.EquipoException;
import demo.Model.Liga;
import demo.Repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Olga on 04/11/2015.
 */
@RestController
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaRepository ligaRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Liga save (@RequestBody Liga liga){
        return ligaRepository.save(liga);

    }
    @RequestMapping (method = RequestMethod.GET)
    public List<Liga> findAll(){
        List<Liga> ligas = new ArrayList<Liga>();
        Iterator<Liga> iterator = ligaRepository.findAll().iterator();
        while(iterator.hasNext()){
            ligas.add(iterator.next());
        }
        return ligas;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Liga findById(@PathVariable Long id) {
        Liga liga = ligaRepository.findOne(id);

        if (liga == null) {
            throw new EquipoException("La liga con " + id + " no existe");
        }
        return liga;
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        Liga liga = ligaRepository.findOne(id);

        if (liga == null){throw new EquipoException("La liga con " + id + " no existe");
        }

        ligaRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Liga updateById(@PathVariable Long id,@RequestBody Liga liga){
        Liga liga1=ligaRepository.findOne(id);

        if(liga1 == null){throw new EquipoException("La liga con " + id + " no existe");}

        return ligaRepository.save(liga);
    }
}
