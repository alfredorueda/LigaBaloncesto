package demo.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipo {
/*En este segundo ejercicio, definiremos la entidad Equipo.
Inicialmente, la entidad Equipo tendrá los siguientes atributos:
identificador, nombre, localidad y fecha de creación.*/
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

    private String nombre;
    private String localidad;
    private Date fechaCreacion;
    private Date fechaNaciemiento;

    /*Un equipo está formado por varios jugadores*/
    @OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadors = new HashSet<>();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set<Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(Set<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

}
