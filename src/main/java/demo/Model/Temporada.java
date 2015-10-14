package demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Temporada {
    /*vamos a considerar que tiene los atributos identificador y año*/
@Id
@GeneratedValue(strategy = GenerationType.AUTO)


    private Date año;

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "año=" + año +
                '}';
    }
}
