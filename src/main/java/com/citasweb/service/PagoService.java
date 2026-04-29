package com.citasweb.service;

import com.citasweb.model.Pago;
import com.citasweb.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService implements IPagoService {

    private final PagoRepository repo;

    @Override
    public Pago save(Pago pago) throws Exception {
        return repo.save(pago);
    }

    @Override
    public Pago update(Pago pago, Integer id) throws Exception {
        Pago existing = findById(id);
        pago.setIdPago(existing.getIdPago());
        return repo.save(pago);
    }

    @Override
    public List<Pago> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Pago findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Pago());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
