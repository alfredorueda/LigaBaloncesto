package demo.Service;

import demo.Model.Jugador;
import demo.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;
    public void testJugador(){
        //Alta 1r jugador
        Jugador jugador = new Jugador();
        jugador.setNombre("Pepe");
        jugador.setAsistenciasTotales(32);
        jugador.setCanastasTotales(67);
        jugador.setRebotesTotales(41);

        Calendar cal=Calendar.getInstance();
        cal.set(1995, Calendar.JANUARY, 1);
        Date birthDate=cal.getTime();

        jugador.setFechaNaciemiento(birthDate);
        jugador.setPosicionCampo("base");

        jugadorRepository.save(jugador);

        //Alta 2n jugador
        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Marc");
        jugador2.setAsistenciasTotales(65);
        jugador2.setCanastasTotales(150);
        jugador2.setRebotesTotales(69);

        Calendar cal2=Calendar.getInstance();
        cal2.set(1990, Calendar.FEBRUARY, 25);
        Date birthDate2=cal2.getTime();

        jugador2.setFechaNaciemiento(birthDate2);
        jugador2.setPosicionCampo("Pivot");

        jugadorRepository.save(jugador2);

        //Alta 3r Jugador
        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Luis");
        jugador3.setAsistenciasTotales(147);
        jugador3.setCanastasTotales(98);
        jugador3.setRebotesTotales(85);

        Calendar cal3=Calendar.getInstance();
        cal3.set(1989, Calendar.OCTOBER, 16);
        Date birthDate3=cal3.getTime();

        jugador3.setFechaNaciemiento(birthDate3);
        jugador3.setPosicionCampo("Escolta");

        jugadorRepository.save(jugador3);

        //Alta 4r Jugador
        Jugador jugador4 = new Jugador();
        jugador4.setNombre("Juan");
        jugador4.setAsistenciasTotales(200);
        jugador4.setCanastasTotales(123);
        jugador4.setRebotesTotales(90);

        Calendar cal4=Calendar.getInstance();
        cal4.set(1984, Calendar.MAY, 20);
        Date birthDate4=cal4.getTime();

        jugador4.setFechaNaciemiento(birthDate4);
        jugador4.setPosicionCampo("base");

        jugadorRepository.save(jugador4);

        //Alta 5 jugador
        Jugador jugador5 = new Jugador();
        jugador5.setNombre("Alfredo");
        jugador5.setAsistenciasTotales(105);
        jugador5.setCanastasTotales(74);
        jugador5.setRebotesTotales(84);

        Calendar cal5=Calendar.getInstance();
        cal5.set(1982, Calendar.JULY, 23);
        Date birthDate5=cal5.getTime();

        jugador5.setFechaNaciemiento(birthDate5);
        jugador5.setPosicionCampo("Ala Pivot");
        jugadorRepository.save(jugador5);

        cal.set(1994, Calendar.MAY, 1);

        //CONSULTAS
        System.out.println(jugadorRepository.findBynombreStartingWith("A"));
        System.out.println(jugadorRepository.findBycanastasTotalesGreaterThanEqual(98));
        System.out.println(jugadorRepository.findByasistenciasTotalesBetween(60, 150));
        System.out.println(jugadorRepository.findByposicionCampoIs("base"));
        System.out.println(jugadorRepository.findByfechaNaciemientoBefore(cal.getTime()));
        System.out.println(jugadorRepository.findBycanastasTotalesGreaterThanEqualAndFechaNaciemientoBefore(123,cal.getTime()));
    }




}
