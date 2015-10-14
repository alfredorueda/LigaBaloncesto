package demo.Repository;

import demo.Model.Liga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LigaRepository extends PagingAndSortingRepository<Liga,Long>{


}
