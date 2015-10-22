package demo.Service;

import demo.Repository.EquipoRepository;
import demo.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;
    public void testEquipo(){



}




}
