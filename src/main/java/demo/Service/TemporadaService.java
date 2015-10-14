package demo.Service;


import demo.Repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemporadaService {
@Autowired
    private TemporadaRepository temporadaRepository;
    public void testTemporada(){}

}
