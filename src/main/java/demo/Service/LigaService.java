package demo.Service;

import demo.Model.Equipo;
import demo.Model.Jugador;
import demo.Model.Liga;
import demo.Model.Temporada;
import demo.Repository.EquipoRepository;
import demo.Repository.JugadorRepository;
import demo.Repository.LigaRepository;
import demo.Repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LigaService {

    @Autowired
    private LigaRepository ligaRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private TemporadaRepository temporadaRepository;



    //creamos una liga
    public void crearLigaAcb(){
        Liga acb=new Liga();
        acb.setNombre("ACB");
        ligaRepository.save(acb);

    }

    //crear dos temporadas
    public void crearTemporadas(){

        crearEquipos();
        crearLigaAcb();
        crearTemporadaT1();
        crearTemporadaT2();
        testConsultas();


    }

    private void testConsultas() {

        System.out.println("Voy a mostrar los equipos que se llaman Barcelona");
        System.out.println(equipoRepository.findByNombreContaining("Barcelona"));
        //Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
        System.out.println("Devolver los jugadores de un equipo sin query");
        System.out.println(jugadorRepository.findByEquipoNombre("Valencia"));

        System.out.println("Devolver los jugadores de un equipo con query");
        System.out.println(jugadorRepository.findByNombreEquipo("Valencia"));

        //Devuelve todos los jugadores de un equipo,
        // que además jueguen en la misma posición, por ejemplo, alero.
        System.out.println("Devolver los jugadores de un equipo que juguen en la misma posicion");
        System.out.println(jugadorRepository.findJugadoresByposicionfromEquipo("Ala Pivot", "Unicaja"));

        //Devuelve el jugador que más canastas ha conseguido del total de jugadores
        System.out.println("El jugador con mas canastas");
        System.out.println(jugadorRepository.findCanastasOrderByCanastaTotales().get(0));
        //Devuelve los cinco jugadores que más asistencias han efectuado
        System.out.println("Los cinco jugadores con mas asistencias");
        System.out.println(jugadorRepository.findByAsistenciasOrderBy().subList(0,5));
        //Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
        System.out.println("Jugador con mas canastas");
        System.out.println(jugadorRepository.findCanastasOrderByCanastasTotales("Valencia").get(0));

    }

    //para cada temporada vincularla con un año
    public void crearTemporadaT1(){
        Temporada t1=new Temporada();
        t1.setNombre("Temporada ACB 2015");
        t1.setAño(2015);
        t1.setLiga(ligaRepository.findOne(1L));
        //añadimos los equipos a la temporada
        t1.getEquipos().add(equipoRepository.findByNombre("Unicaja"));
        t1.getEquipos().add(equipoRepository.findByNombre("Valencia"));
        t1.getEquipos().add(equipoRepository.findByNombre("Leon"));
        temporadaRepository.save(t1);
    }

     public void crearTemporadaT2(){

         Temporada t2=new Temporada();
         t2.setNombre("Temporada ACB 2016");
         t2.setLiga(ligaRepository.findOne(1L));
         t2.setAño(2016);


         t2.getEquipos().add(equipoRepository.findByNombre("Barcelona"));
         t2.getEquipos().add(equipoRepository.findByNombre("Herbalife"));
         temporadaRepository.save(t2);
     }

    //cremos cinco equipos
    public void crearEquipos(){

        crearEquipoBarca();
        crearEquipoUnicaja();
        crearEquipoValencia();
        crearEquipoHerbalife();
        crearEquipoLeon();
    }

    // llenamos cada equipos con cinco jugadores
    private void crearEquipoLeon() {
        Equipo leon= new Equipo();
        leon.setNombre("Leon");
        leon.setLocalidad("Leon");
        Calendar leones=Calendar.getInstance();
        leones.set(1965, Calendar.FEBRUARY, 15);
        Date birthDateL=leones.getTime();
        leon.setFechaCreacion(birthDateL);
        equipoRepository.save(leon);

        Jugador mariano=new Jugador();
        mariano.setNombre("Mariano");
        mariano.setEquipo(leon);
        mariano.setRebotesTotales(124);
        mariano.setCanastasTotales(205);
        mariano.setAsistenciasTotales(187);
        mariano.setPosicionCampo("Base");
        Calendar cal20=Calendar.getInstance();
        cal20.set(1986, Calendar.NOVEMBER, 26);
        Date birthDate20=cal20.getTime();
        mariano.setFechaNaciemiento(birthDate20);
        jugadorRepository.save(mariano);

        Jugador pepe=new Jugador();
        pepe.setNombre("Pepe");
        pepe.setEquipo(leon);
        pepe.setRebotesTotales(67);
        pepe.setCanastasTotales(168);
        pepe.setAsistenciasTotales(57);
        pepe.setPosicionCampo("Ala");
        Calendar cal21=Calendar.getInstance();
        cal21.set(2002, Calendar.JANUARY, 5);
        Date birthDate21=cal21.getTime();
        pepe.setFechaNaciemiento(birthDate21);
        jugadorRepository.save(pepe);

        Jugador rodriguez=new Jugador();
        rodriguez.setNombre("Rodriguez");
        rodriguez.setEquipo(leon);
        rodriguez.setRebotesTotales(36);
        rodriguez.setCanastasTotales(15);
        rodriguez.setAsistenciasTotales(43);
        rodriguez.setPosicionCampo("Ala Pivot");
        Calendar cal22=Calendar.getInstance();
        cal22.set(2002, Calendar.JANUARY, 5);
        Date birthDate22=cal22.getTime();
        rodriguez.setFechaNaciemiento(birthDate22);
        jugadorRepository.save(rodriguez);

        Jugador gasol=new Jugador();
        gasol.setNombre("Gasol");
        gasol.setEquipo(leon);
        gasol.setRebotesTotales(216);
        gasol.setCanastasTotales(365);
        gasol.setAsistenciasTotales(248);
        gasol.setPosicionCampo("Ala Pivot");
        Calendar cal23=Calendar.getInstance();
        cal23.set(1998, Calendar.APRIL, 19);
        Date birthDate23=cal23.getTime();
        gasol.setFechaNaciemiento(birthDate23);
        jugadorRepository.save(gasol);

        Jugador samuel=new Jugador();
        samuel.setNombre("Samuel");
        samuel.setEquipo(leon);
        samuel.setRebotesTotales(216);
        samuel.setCanastasTotales(365);
        samuel.setAsistenciasTotales(248);
        samuel.setPosicionCampo("Ala Pivot");
        Calendar cal24=Calendar.getInstance();
        cal24.set(1999, Calendar.MARCH, 30);
        Date birthDate24=cal24.getTime();
        samuel.setFechaNaciemiento(birthDate24);
        jugadorRepository.save(samuel);

    }


    private void crearEquipoHerbalife() {
        Equipo herbalife = new Equipo();
        herbalife.setNombre("Herbalife");
        herbalife.setLocalidad("Gran Canaria");
        Calendar leones=Calendar.getInstance();
        leones.set(1970, Calendar.APRIL, 22);
        Date birthDateGC=leones.getTime();
        herbalife.setFechaCreacion(birthDateGC);
        equipoRepository.save(herbalife);

        Jugador oliver=new Jugador();
        oliver.setNombre("Oliver");
        oliver.setEquipo(herbalife);
        oliver.setRebotesTotales(165);
        oliver.setCanastasTotales(204);
        oliver.setAsistenciasTotales(164);
        oliver.setPosicionCampo("Escolta");
        Calendar cal15=Calendar.getInstance();
        cal15.set(1987, Calendar.FEBRUARY, 28);
        Date birthDate15=cal15.getTime();
        oliver.setFechaNaciemiento(birthDate15);
        jugadorRepository.save(oliver);

        Jugador pangos=new Jugador();
        pangos.setNombre("Pangos");
        pangos.setEquipo(herbalife);
        pangos.setRebotesTotales(205);
        pangos.setCanastasTotales(169);
        pangos.setAsistenciasTotales(84);
        pangos.setPosicionCampo("Pivot");
        Calendar cal16=Calendar.getInstance();
        cal16.set(1986, Calendar.APRIL, 6);
        Date birthDate16=cal16.getTime();
        pangos.setFechaNaciemiento(birthDate16);
        jugadorRepository.save(pangos);

        Jugador salin=new Jugador();
        salin.setNombre("Salin");
        salin.setEquipo(herbalife);
        salin.setRebotesTotales(199);
        salin.setCanastasTotales(74);
        salin.setAsistenciasTotales(215);
        salin.setPosicionCampo("Ala Pivot");
        Calendar cal17=Calendar.getInstance();
        cal17.set(1986, Calendar.APRIL, 6);
        Date birthDate17=cal17.getTime();
        salin.setFechaNaciemiento(birthDate17);
        jugadorRepository.save(salin);

        Jugador newley=new Jugador();
        newley.setNombre("Newley");
        newley.setEquipo(herbalife);
        newley.setRebotesTotales(199);
        newley.setCanastasTotales(74);
        newley.setAsistenciasTotales(215);
        newley.setPosicionCampo("Base");
        Calendar cal18=Calendar.getInstance();
        cal18.set(2001, Calendar.AUGUST, 2);
        Date birthDate18=cal18.getTime();
        newley.setFechaNaciemiento(birthDate18);
        jugadorRepository.save(newley);

        Jugador pauli=new Jugador();
        pauli.setNombre("Pauli");
        pauli.setEquipo(herbalife);
        pauli.setRebotesTotales(199);
        pauli.setCanastasTotales(74);
        pauli.setAsistenciasTotales(215);
        pauli.setPosicionCampo("Pivot");
        Calendar cal19=Calendar.getInstance();
        cal19.set(1982, Calendar.AUGUST, 15);
        Date birthDate19=cal19.getTime();
        pauli.setFechaNaciemiento(birthDate19);
        jugadorRepository.save(pauli);
    }

    private void crearEquipoValencia() {
        Equipo valencia = new Equipo();
        valencia.setNombre("Valencia");
        valencia.setLocalidad("Valencia");
        Calendar val=Calendar.getInstance();
        val.set(1954, Calendar.JANUARY, 7);
        Date birthDateV=val.getTime();
        valencia.setFechaCreacion(birthDateV);
        equipoRepository.save(valencia);

        Jugador sam=new Jugador();
        sam.setNombre("Sam");
        sam.setEquipo(valencia);
        sam.setRebotesTotales(225);
        sam.setCanastasTotales(99);
        sam.setAsistenciasTotales(199);
        sam.setPosicionCampo("Pivot");
        Calendar cal10=Calendar.getInstance();
        cal10.set(1989, Calendar.JULY, 16);
        Date birthDate10=cal10.getTime();
        sam.setFechaNaciemiento(birthDate10);
        jugadorRepository.save(sam);

        Jugador diot=new Jugador();
        diot.setNombre("Diot");
        diot.setEquipo(valencia);
        diot.setRebotesTotales(147);
        diot.setCanastasTotales(69);
        diot.setAsistenciasTotales(201);
        diot.setPosicionCampo("Pivot");
        Calendar cal11=Calendar.getInstance();
        cal11.set(1996, Calendar.MAY, 14);
        Date birthDate11=cal11.getTime();
        diot.setFechaNaciemiento(birthDate11);
        jugadorRepository.save(diot);

        Jugador guillem=new Jugador();
        guillem.setNombre("Guillem");
        guillem.setEquipo(valencia);
        guillem.setRebotesTotales(65);
        guillem.setCanastasTotales(30);
        guillem.setAsistenciasTotales(48);
        guillem.setPosicionCampo("Escolta");
        Calendar cal12=Calendar.getInstance();
        cal12.set(1999, Calendar.MARCH, 29);
        Date birthDate12=cal12.getTime();
        guillem.setFechaNaciemiento(birthDate12);
        jugadorRepository.save(guillem);

        Jugador jon=new Jugador();
        jon.setNombre("Jon");
        jon.setEquipo(valencia);
        jon.setRebotesTotales(103);
        jon.setCanastasTotales(87);
        jon.setAsistenciasTotales(150);
        jon.setPosicionCampo("Base");
        Calendar cal13=Calendar.getInstance();
        cal13.set(2000, Calendar.JUNE, 13);
        Date birthDate13=cal13.getTime();
        jon.setFechaNaciemiento(birthDate13);
        jugadorRepository.save(jon);

        Jugador trias=new Jugador();
        trias.setNombre("Trias");
        trias.setEquipo(valencia);
        trias.setRebotesTotales(99);
        trias.setCanastasTotales(99);
        trias.setAsistenciasTotales(99);
        trias.setPosicionCampo("Pivot");
        Calendar cal14=Calendar.getInstance();
        cal14.set(2000, Calendar.JUNE, 13);
        Date birthDate14=cal14.getTime();
        trias.setFechaNaciemiento(birthDate14);
        jugadorRepository.save(trias);
    }

    private void crearEquipoUnicaja() {
        Equipo unicaja = new Equipo();
        unicaja.setNombre("Unicaja");
        unicaja.setLocalidad("Malaga");
        Calendar malaga=Calendar.getInstance();
        malaga.set(1954, Calendar.NOVEMBER, 18);
        Date birthDateM=malaga.getTime();
        unicaja.setFechaCreacion(birthDateM);
        equipoRepository.save(unicaja);

        Jugador jackson=new Jugador();
        jackson.setNombre("Jackson");
        jackson.setEquipo(unicaja);
        jackson.setRebotesTotales(148);
        jackson.setCanastasTotales(254);
        jackson.setAsistenciasTotales(365);
        jackson.setPosicionCampo("Pivot");
        Calendar cal5=Calendar.getInstance();
        cal5.set(1974, Calendar.MARCH, 25);
        Date birthDate5=cal5.getTime();
        jackson.setFechaNaciemiento(birthDate5);
        jugadorRepository.save(jackson);

        Jugador gabriel=new Jugador();
        gabriel.setNombre("Gabriel");
        gabriel.setEquipo(unicaja);
        gabriel.setRebotesTotales(240);
        gabriel.setCanastasTotales(145);
        gabriel.setAsistenciasTotales(65);
        gabriel.setPosicionCampo("Ala-Pivot");
        Calendar cal6=Calendar.getInstance();
        cal6.set(1984, Calendar.SEPTEMBER, 18);
        Date birthDate6=cal6.getTime();
        gabriel.setFechaNaciemiento(birthDate6);
        jugadorRepository.save(gabriel);


        Jugador thomas=new Jugador();
        thomas.setNombre("Thomas");
        thomas.setEquipo(unicaja);
        thomas.setRebotesTotales(210);
        thomas.setCanastasTotales(47);
        thomas.setAsistenciasTotales(67);
        thomas.setPosicionCampo("Escolta");
        Calendar cal7=Calendar.getInstance();
        cal7.set(1986, Calendar.AUGUST, 14);
        Date birthDate7=cal7.getTime();
        thomas.setFechaNaciemiento(birthDate7);
        jugadorRepository.save(thomas);

        Jugador diaz=new Jugador();
        diaz.setNombre("Díaz");
        diaz.setEquipo(unicaja);
        diaz.setRebotesTotales(124);
        diaz.setCanastasTotales(65);
        diaz.setAsistenciasTotales(200);
        diaz.setPosicionCampo("Ala Pivot");
        Calendar cal8=Calendar.getInstance();
        cal8.set(1990, Calendar.JANUARY, 29);
        Date birthDate8=cal8.getTime();
        diaz.setFechaNaciemiento(birthDate8);
        jugadorRepository.save(diaz);

        Jugador hendrix=new Jugador();
        hendrix.setNombre("Hendrix");
        hendrix.setEquipo(unicaja);
        hendrix.setRebotesTotales(225);
        hendrix.setCanastasTotales(99);
        hendrix.setAsistenciasTotales(199);
        hendrix.setPosicionCampo("Base");
        Calendar cal9=Calendar.getInstance();
        cal9.set(1992, Calendar.OCTOBER, 18);
        Date birthDate9=cal9.getTime();
        hendrix.setFechaNaciemiento(birthDate9);
        jugadorRepository.save(hendrix);
    }

     private void crearEquipoBarca() {
        Equipo barcelona = new Equipo();
        barcelona.setNombre("Barcelona");
         barcelona.setLocalidad("Barcelona");
         Calendar bcn=Calendar.getInstance();
         bcn.set(1984, Calendar.OCTOBER, 25);
         Date birthDateB=bcn.getTime();
         barcelona.setFechaCreacion(birthDateB);
        equipoRepository.save(barcelona);


        Jugador navarro=new Jugador();
        navarro.setNombre("Navarro");
        navarro.setEquipo(barcelona);
        navarro.setRebotesTotales(148);
        navarro.setCanastasTotales(254);
        navarro.setAsistenciasTotales(365);
        navarro.setPosicionCampo("Pivot");
        Calendar cal=Calendar.getInstance();
        cal.set(1986, Calendar.FEBRUARY, 12);
        Date birthDate=cal.getTime();
        navarro.setFechaNaciemiento(birthDate);
        jugadorRepository.save(navarro);

        Jugador justin=new Jugador();
        justin.setNombre("Justin");
        justin.setEquipo(barcelona);
        justin.setRebotesTotales(89);
        justin.setCanastasTotales(100);
        justin.setAsistenciasTotales(69);
        justin.setPosicionCampo("base");
        Calendar cal1=Calendar.getInstance();
        cal1.set(1985, Calendar.MAY, 25);
        Date birthDate1=cal1.getTime();
        justin.setFechaNaciemiento(birthDate1);
        jugadorRepository.save(justin);

        Jugador ribas=new Jugador();
        ribas.setNombre("Ribas");
        ribas.setEquipo(barcelona);
        ribas.setRebotesTotales(74);
        ribas.setCanastasTotales(256);
        ribas.setAsistenciasTotales(135);
        ribas.setPosicionCampo("Ala-Pivot");
        Calendar cal2=Calendar.getInstance();
        cal2.set(1984, Calendar.SEPTEMBER, 16);
        Date birthDate2=cal2.getTime();
        ribas.setFechaNaciemiento(birthDate2);
        jugadorRepository.save(ribas);

        Jugador oleson=new Jugador();
        oleson.setNombre("Oleson");
        oleson.setEquipo(barcelona);
        oleson.setRebotesTotales(69);
        oleson.setCanastasTotales(124);
        oleson.setAsistenciasTotales(104);
        oleson.setPosicionCampo("Escolta");
        Calendar cal3=Calendar.getInstance();
        cal3.set(1982, Calendar.JULY, 25);
        Date birthDate3=cal3.getTime();
        oleson.setFechaNaciemiento(birthDate3);
        jugadorRepository.save(oleson);

        Jugador tomic=new Jugador();
        tomic.setNombre("Tomic");
        tomic.setEquipo(barcelona);
        tomic.setRebotesTotales(184);
        tomic.setCanastasTotales(157);
        tomic.setAsistenciasTotales(99);
        tomic.setPosicionCampo("Pivot");
        Calendar cal4=Calendar.getInstance();
        cal4.set(1975, Calendar.NOVEMBER, 29);
        Date birthDate4=cal4.getTime();
        tomic.setFechaNaciemiento(birthDate4);
        jugadorRepository.save(tomic);
    }
}
