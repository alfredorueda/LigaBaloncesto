package demo.Repository;

        import demo.Model.Jugador;
        import org.springframework.data.repository.PagingAndSortingRepository;

        import java.util.Date;
        import java.util.List;


public interface JugadorRepository extends PagingAndSortingRepository<Jugador,Long> {

    /*Buscar jugadores por nombre, de manera que no sea necesario
    introducir el nombre completo.*/

    public List<Jugador> findBynombreStartingWith(String nombre);

    /*Buscar jugadores que hayan conseguido un número mayor o igual
    a un número de canastas especificado como parámetro.*/

    public List<Jugador>findBycanastasTotalesGreaterThanEqual(Integer canastasTotales);

    /*Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango
    especificado como parámetro (El rango se específica mediante un valor mínimo y un
    valor máximo).*/

    public List<Jugador>findByasistenciasTotalesBetween(Integer minAsistencias, Integer maxAsistencias);

    /*Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base*/

    public List<Jugador>findByposicionCampoIs(String posicionCampo);

    /*Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada
    como parámetro.*/

    public List<Jugador>findByfechaNaciemientoBefore(Date fechaNacimiento);

    /*Combinar los apartados B y E: es decir, la consulta ha de devolver los
    jugadores que hayan conseguido un número total de canastas mayor o igual a un
    parámetro, y además que he nacido en una fecha anterior a una fecha especificada
    como parámetro.*/

    public List<Jugador>findBycanastasTotalesGreaterThanEqualAndFechaNaciemientoBefore(Integer canastasTotales,Date fechaNacimiento);
}
