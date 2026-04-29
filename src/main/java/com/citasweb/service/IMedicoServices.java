package com.citasweb.service;

import com.citasweb.model.Medico;
import java.util.List;

public interface IMedicoServices {
    Medico save(Medico medico) throws Exception;
    Medico update(Medico medico, Integer id) throws Exception;
    List<Medico> findAll() throws Exception;
    Medico findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
