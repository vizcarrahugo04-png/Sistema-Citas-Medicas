package com.citasweb.service;

import com.citasweb.model.Administrador;
import com.citasweb.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorServices implements IAdministradorService {

    private final AdministradorRepository repo;

    @Override
    public Administrador save(Administrador administrador) throws Exception {
        return repo.save(administrador);
    }

    @Override
    public Administrador update(Administrador administrador, Integer id) throws Exception {
        Administrador existing = findById(id);
        administrador.setIdAdministrador(existing.getIdAdministrador());
        return repo.save(administrador);
    }

    @Override
    public List<Administrador> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Administrador findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Administrador());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
