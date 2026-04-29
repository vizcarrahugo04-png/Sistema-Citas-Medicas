package com.citasweb.service;

import com.citasweb.model.HistoriaClinica;
import com.citasweb.repository.HistoriaClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServices implements IHistoriaClinicaService {

    private final HistoriaClinicaRepository repo;

    @Override
    public HistoriaClinica save(HistoriaClinica historiaClinica) throws Exception {
        return repo.save(historiaClinica);
    }

    @Override
    public HistoriaClinica update(HistoriaClinica historiaClinica, Integer id) throws Exception {
        HistoriaClinica existing = findById(id);
        historiaClinica.setIdHistoria(existing.getIdHistoria()); // 🔥 corregido
        return repo.save(historiaClinica);
    }

    @Override
    public List<HistoriaClinica> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public HistoriaClinica findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new HistoriaClinica());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
