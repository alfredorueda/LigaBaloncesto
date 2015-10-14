package demo.Service;

import demo.Model.Equipo;
import demo.Repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LigaService {
    @Autowired
    private LigaRepository ligaRepository;
    public void testLiga(){


    Equipo equipo = new Equipo();

    equipo.getJugadors().add("Navarro");
    equipo.getJugadors().add("Justin");
    equipo.getJugadors().add("Marcus");
    equipo.getJugadors().add("Àlex");
    equipo.getJugadors().add("Brad");


}

}
