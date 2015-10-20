package demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Temporada {
    /*vamos a considerar que tiene los atributos identificador y año*/
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Date año;

    /*Una temporada esta formada por varias ligas*/
    @ManyToOne
    private Liga liga;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "id=" + id +
                ", año=" + año +
                ", liga=" + liga +
                '}';
    }
}
