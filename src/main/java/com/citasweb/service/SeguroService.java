package com.citasweb.service;

import com.citasweb.model.Seguro;
import com.citasweb.repository.SeguroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeguroService implements ISeguroService {

    private final SeguroRepository repo;

    @Override
    public Seguro save(Seguro seguro) throws Exception {
        return repo.save(seguro);
    }

    @Override
    public Seguro update(Seguro seguro, Integer id) throws Exception {
        Seguro existing = findById(id);
        seguro.setIdSeguro(existing.getIdSeguro());
        return repo.save(seguro);
    }

    @Override
    public List<Seguro> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Seguro findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Seguro());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
