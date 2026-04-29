package com.citasweb.controller;

import com.citasweb.model.Especialidad;
import com.citasweb.service.IEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService service;

    @PostMapping
    public ResponseEntity<Especialidad> save(@RequestBody Especialidad especialidad) throws Exception {
        Especialidad obj = service.save(especialidad);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> update(@RequestBody Especialidad especialidad, @PathVariable("id") Integer id) throws Exception {
        Especialidad obj = service.update(especialidad, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> findAll() throws Exception {
        List<Especialidad> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable("id") Integer id) throws Exception {
        Especialidad obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

