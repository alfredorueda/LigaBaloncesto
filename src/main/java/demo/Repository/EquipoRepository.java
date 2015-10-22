package demo.Repository;

import demo.Model.Equipo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EquipoRepository extends PagingAndSortingRepository <Equipo, Long> {

    Equipo findByNombre(String nombre);

    //Consulta los equipos existentes en una localidad determinada.
    public List<Equipo> findByNombreContaining(String nombre);

    //Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.


    //Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición, por ejemplo, alero.


    //Devuelve el jugador que más canastas ha conseguido del total de jugadores


    //Devuelve los cinco jugadores que más asistencias han efectuado
}