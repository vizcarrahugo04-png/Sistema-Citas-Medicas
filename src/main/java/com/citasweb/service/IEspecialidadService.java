package com.citasweb.service;

import com.citasweb.model.Especialidad;
import java.util.List;

public interface IEspecialidadService {
    Especialidad save(Especialidad especialidad) throws Exception;
    Especialidad update(Especialidad especialidad, Integer id) throws Exception;
    List<Especialidad> findAll() throws Exception;
    Especialidad findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
