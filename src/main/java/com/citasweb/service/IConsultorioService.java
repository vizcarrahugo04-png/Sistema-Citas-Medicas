package com.citasweb.service;

import com.citasweb.model.Consultorio;
import java.util.List;

public interface IConsultorioService {
    Consultorio save(Consultorio consultorio) throws Exception;
    Consultorio update(Consultorio consultorio, Integer id) throws Exception;
    List<Consultorio> findAll() throws Exception;
    Consultorio findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
