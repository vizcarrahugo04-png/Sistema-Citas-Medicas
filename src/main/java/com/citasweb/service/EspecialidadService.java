package com.citasweb.service;

import com.citasweb.model.Especialidad;
import com.citasweb.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadService implements IEspecialidadService {

    private final EspecialidadRepository repo;

    @Override
    public Especialidad save(Especialidad especialidad) throws Exception {
        return repo.save(especialidad);
    }

    @Override
    public Especialidad update(Especialidad especialidad, Integer id) throws Exception {
        Especialidad existing = findById(id);
        especialidad.setIdEspecialidad(existing.getIdEspecialidad());
        return repo.save(especialidad);
    }

    @Override
    public List<Especialidad> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Especialidad findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Especialidad());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
