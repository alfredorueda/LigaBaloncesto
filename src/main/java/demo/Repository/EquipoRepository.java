package demo.Repository;

import demo.Model.Equipo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EquipoRepository extends PagingAndSortingRepository <Equipo, Long> {

    Equipo findByNombre(String nombre);

    //Consulta los equipos existentes en una localidad determinada.
    public List<Equipo> findByNombreContaining(String nombre);


}