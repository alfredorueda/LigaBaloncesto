package demo;

import demo.Model.Jugador;
import demo.Service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LigaBaloncestoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(LigaBaloncestoApplication.class, args);

        JugadorService jugadorService = context.getBean(JugadorService.class);

        jugadorService.testJugador();
    }
}
