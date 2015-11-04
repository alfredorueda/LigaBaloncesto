package demo.Controller;

import demo.Exception.TemporadaException;
import demo.Model.Temporada;
import demo.Repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/temporada")
public class TemporadaController {

    @Autowired
    private TemporadaRepository temporadaRepository;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Temporada save(@RequestBody Temporada temporada) {
        return temporadaRepository.save(temporada);

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Temporada> findAll() {
        List<Temporada> temporadas = new ArrayList<Temporada>();
        Iterator<Temporada> iterator = temporadaRepository.findAll().iterator();

        while (iterator.hasNext()) {
            temporadas.add(iterator.next());
        }
        return temporadas;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Temporada temporada = temporadaRepository.findOne(id);

        if (temporada == null) {
            throw new TemporadaException("La temporada con " + id + " no existe");
        }
        temporadaRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Temporada findById(@PathVariable Long id) {
        Temporada temporada = temporadaRepository.findOne(id);

        if (temporada == null) {
            throw new TemporadaException("La temporada con " + id + " no existe");
        }
        return temporada;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Temporada updateById(@PathVariable Long id, @RequestBody Temporada temporada) {
        Temporada temporada1 = temporadaRepository.findOne(id);

        if (temporada1 == null) {
            throw new TemporadaException("La temporada con " + id + " no existe");
        }

        return temporadaRepository.save(temporada);
    }

}
