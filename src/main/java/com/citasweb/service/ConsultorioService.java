package com.citasweb.service;

import com.citasweb.model.Consultorio;
import com.citasweb.repository.ConsultorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultorioService implements IConsultorioService {

    private final ConsultorioRepository repo;

    @Override
    public Consultorio save(Consultorio consultorio) throws Exception {
        return repo.save(consultorio);
    }

    @Override
    public Consultorio update(Consultorio consultorio, Integer id) throws Exception {
        Consultorio existing = findById(id);
        consultorio.setIdConsultorio(existing.getIdConsultorio());
        return repo.save(consultorio);
    }

    @Override
    public List<Consultorio> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Consultorio findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Consultorio());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
