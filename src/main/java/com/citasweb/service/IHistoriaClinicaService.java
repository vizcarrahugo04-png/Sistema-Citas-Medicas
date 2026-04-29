package com.citasweb.service;

import com.citasweb.model.HistoriaClinica;
import java.util.List;

public interface IHistoriaClinicaService {
    HistoriaClinica save(HistoriaClinica historiaClinica) throws Exception;
    HistoriaClinica update(HistoriaClinica historiaClinica, Integer id) throws Exception;
    List<HistoriaClinica> findAll() throws Exception;
    HistoriaClinica findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
