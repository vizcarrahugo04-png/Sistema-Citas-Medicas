package com.citasweb.service;

import com.citasweb.model.Seguro;
import java.util.List;

public interface ISeguroService {
    Seguro save(Seguro seguro) throws Exception;
    Seguro update(Seguro seguro, Integer id) throws Exception;
    List<Seguro> findAll() throws Exception;
    Seguro findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
