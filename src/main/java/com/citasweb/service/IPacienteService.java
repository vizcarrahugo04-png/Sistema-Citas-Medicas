package com.citasweb.service;

import com.citasweb.model.Paciente;
import java.util.List;

public interface IPacienteService {
    Paciente save(Paciente paciente) throws Exception;
    Paciente update(Paciente paciente, Integer id) throws Exception;
    List<Paciente> findAll() throws Exception;
    Paciente findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
