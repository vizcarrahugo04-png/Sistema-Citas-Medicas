package com.citasweb.service;

import com.citasweb.model.Medico;
import com.citasweb.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServices implements IMedicoServices {

    private final MedicoRepository repo;

    @Override
    public Medico save(Medico medico) throws Exception {
        return repo.save(medico);
    }

    @Override
    public Medico update(Medico medico, Integer id) throws Exception {
        Medico existing = findById(id);
        medico.setIdMedico(existing.getIdMedico());
        return repo.save(medico);
    }

    @Override
    public List<Medico> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Medico findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Medico());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
