package demo.Repository;


import demo.Model.Temporada;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TemporadaRepository extends PagingAndSortingRepository <Temporada,Long> {


}
