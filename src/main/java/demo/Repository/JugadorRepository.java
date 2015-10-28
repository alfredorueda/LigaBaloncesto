package demo.Repository;

        import demo.Model.Jugador;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.data.repository.query.Param;

        import java.util.Date;
        import java.util.List;


public interface JugadorRepository extends PagingAndSortingRepository<Jugador,Long> {

    /*Buscar jugadores por nombre, de manera que no sea necesario
    introducir el nombre completo.*/

    public List<Jugador> findBynombreStartingWith(String nombre);

    /*Buscar jugadores que hayan conseguido un número mayor o igual
    a un número de canastas especificado como parámetro.*/

    public List<Jugador> findBycanastasTotalesGreaterThanEqual(Integer canastasTotales);

    /*Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango
    especificado como parámetro (El rango se específica mediante un valor mínimo y un
    valor máximo).*/

    public List<Jugador> findByasistenciasTotalesBetween(Integer minAsistencias, Integer maxAsistencias);

    /*Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base*/

    public List<Jugador> findByposicionCampoIs(String posicionCampo);

    /*Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada
    como parámetro.*/

    public List<Jugador> findByfechaNaciemientoBefore(Date fechaNacimiento);

    /*Combinar los apartados B y E: es decir, la consulta ha de devolver los
    jugadores que hayan conseguido un número total de canastas mayor o igual a un
    parámetro, y además que he nacido en una fecha anterior a una fecha especificada
    como parámetro.*/

    public List<Jugador> findBycanastasTotalesGreaterThanEqualAndFechaNaciemientoBefore(Integer canastasTotales, Date fechaNacimiento);

    //Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
    List<Jugador> findByEquipoNombre(String nombreEquipo);

    @Query("select j from Jugador j where j.equipo.nombre=:nombreEquipo")
    List<Jugador> findByNombreEquipo(@Param("nombreEquipo") String nombreEquipo);

    //Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición,
    // por ejemplo, alero.
    @Query("select j from Jugador j where j.posicionCampo=:posicionCampoJugador and j.equipo.nombre=:nombreEquipo")
    List<Jugador> findJugadoresByposicionfromEquipo(@Param("posicionCampoJugador") String posicionCampo, @Param("nombreEquipo") String nombreEquipo);

    //Devuelve el jugador que más canastas ha conseguido del total de jugadores
    @Query("select j from Jugador j  order by j.canastasTotales desc")
    List<Jugador> findCanastasOrderByCanastaTotales();

    //Devuelve los cinco jugadores que más asistencias han efectuado
    @Query("select  j from Jugador j order by j.asistenciasTotales desc ")
    List<Jugador> findByAsistenciasOrderBy();

    //Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
    @Query("SELECT j FROM Jugador j where j.equipo.nombre = :nombreEquipo order by j.canastasTotales desc ")
    List<Jugador> findCanastasOrderByCanastasTotales(@Param("nombreEquipo") String nombreEquipo);

}
/*Programar los controladores REST para las entidades jugador, equipo, temporada y liga*/
