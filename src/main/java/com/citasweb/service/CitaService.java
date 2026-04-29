package com.citasweb.service;

import com.citasweb.model.Cita;
import com.citasweb.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService implements ICitaService {

    private final CitaRepository repo;

    @Override
    public Cita save(Cita cita) throws Exception {
        return repo.save(cita);
    }

    @Override
    public Cita update(Cita cita, Integer id) throws Exception {
        Cita existing = findById(id);
        cita.setIdCita(existing.getIdCita());
        return repo.save(cita);
    }

    @Override
    public List<Cita> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Cita findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Cita());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
