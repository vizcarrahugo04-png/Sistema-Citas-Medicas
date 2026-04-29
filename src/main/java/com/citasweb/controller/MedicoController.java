package com.citasweb.controller;

import com.citasweb.model.Medico;
import com.citasweb.service.IMedicoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final IMedicoServices service;

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) throws Exception {
        Medico obj = service.save(medico);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@RequestBody Medico medico, @PathVariable("id") Integer id) throws Exception {
        Medico obj = service.update(medico, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() throws Exception {
        List<Medico> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable("id") Integer id) throws Exception {
        Medico obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

