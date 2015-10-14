package demo;

import demo.Model.Equipo;
import demo.Model.Jugador;
import demo.Repository.LigaRepository;
import demo.Service.EquipoService;
import demo.Service.JugadorService;
import demo.Service.LigaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LigaBaloncestoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(LigaBaloncestoApplication.class, args);

        JugadorService jugadorService = context.getBean(JugadorService.class);

        jugadorService.testJugador();

        EquipoService equipoService=context.getBean(EquipoService.class);

        equipoService.testEquipo();

        LigaService ligaService=context.getBean(LigaService.class);

        ligaService.testLiga();


    }
}
