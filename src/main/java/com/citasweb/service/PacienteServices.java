package com.citasweb.service;

import com.citasweb.model.Paciente;
import com.citasweb.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServices implements IPacienteService {

    private final PacienteRepository repo;

    @Override
    public Paciente save(Paciente paciente) throws Exception {
        return repo.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente, Integer id) throws Exception {
        Paciente existing = findById(id);
        paciente.setIdPaciente(existing.getIdPaciente());
        return repo.save(paciente);
    }

    @Override
    public List<Paciente> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Paciente findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Paciente());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
