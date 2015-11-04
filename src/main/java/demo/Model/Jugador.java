package demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Jugador {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

//Empezaremos con la entidad jugador. La entidad jugador tendrá los siguientes atributos:
// un identificador, un nombre, una fecha de nacimiento, un número de canastas totales,
//un número de asistencias totales, un número de rebotes totales y una posición en el
//campo por defecto (alero, base, etc.).

    private Long id;
    private String nombre;
    private Date fechaNaciemiento;
    private Integer canastasTotales;
    private Integer asistenciasTotales;
    private Integer rebotesTotales;
    private String posicionCampo;

    /*Un jugador sólo puede participar en un equipo*/
    @JsonIgnore
    @ManyToOne
    private Equipo equipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public Integer getCanastasTotales() {
        return canastasTotales;
    }

    public void setCanastasTotales(Integer canastasTotales) {
        this.canastasTotales = canastasTotales;
    }

    public Integer getAsistenciasTotales() {
        return asistenciasTotales;
    }

    public void setAsistenciasTotales(Integer asistenciasTotales) {
        this.asistenciasTotales = asistenciasTotales;
    }

    public Integer getRebotesTotales() {
        return rebotesTotales;
    }

    public void setRebotesTotales(Integer rebotesTotales) {
        this.rebotesTotales = rebotesTotales;
    }

    public String getPocicionCampo() {
        return posicionCampo;
    }

    public void setPosicionCampo(String pocicionCampo) {
        this.posicionCampo = pocicionCampo;
    }

    public String getPosicionCampo() {
        return posicionCampo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo (Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNaciemiento=" + fechaNaciemiento +
                ", canastasTotales=" + canastasTotales +
                ", asistenciasTotales=" + asistenciasTotales +
                ", rebotesTotales=" + rebotesTotales +
                ", posicionCampo='" + posicionCampo + '\'' +
                ", equipo='" +equipo.getNombre() + '\'' +
                '}';
    }
}
