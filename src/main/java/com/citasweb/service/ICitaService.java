package com.citasweb.service;

import com.citasweb.model.Cita;
import java.util.List;

public interface ICitaService {
    Cita save(Cita cita) throws Exception;
    Cita update(Cita cita, Integer id) throws Exception;
    List<Cita> findAll() throws Exception;
    Cita findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
