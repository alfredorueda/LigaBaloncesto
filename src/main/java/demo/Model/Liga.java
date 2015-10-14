package demo.Model;

import javax.persistence.*;

@Entity
public class Liga {

/*La entidad liga simplemente tendrá un identificador y un nombre.*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
