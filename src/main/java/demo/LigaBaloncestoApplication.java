package demo;

import demo.Service.EquipoService;
import demo.Service.JugadorService;
import demo.Service.LigaService;
import demo.Service.TemporadaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LigaBaloncestoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(LigaBaloncestoApplication.class, args);



        LigaService ligaService=context.getBean(LigaService.class);

        ligaService.crearTemporadas();






    }
}
