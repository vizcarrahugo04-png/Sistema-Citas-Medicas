package com.citasweb.service;

import com.citasweb.model.Administrador;
import java.util.List;

public interface IAdministradorService {
    List<Administrador> findAll() throws Exception;
    Administrador findById(Integer id) throws Exception;
    Administrador save(Administrador administrador) throws Exception;
    Administrador update(Administrador administrador, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
