package demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Temporada {
    /*vamos a considerar que tiene los atributos identificador y año*/
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Integer año;
    private String nombre;

    /*Una temporada esta formada por varias ligas*/
    @ManyToOne
    private Liga liga;

    /*Varios equipos estan en varias temporadas*/
    @ManyToMany
    private Set<Equipo> equipos=new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
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
