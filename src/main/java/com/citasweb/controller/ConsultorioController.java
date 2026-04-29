package com.citasweb.controller;

import com.citasweb.model.Consultorio;
import com.citasweb.service.IConsultorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorios")
@RequiredArgsConstructor
public class ConsultorioController {

    private final IConsultorioService service;

    @PostMapping
    public ResponseEntity<Consultorio> save(@RequestBody Consultorio consultorio) throws Exception {
        Consultorio obj = service.save(consultorio);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultorio> update(@RequestBody Consultorio consultorio, @PathVariable("id") Integer id) throws Exception {
        Consultorio obj = service.update(consultorio, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Consultorio>> findAll() throws Exception {
        List<Consultorio> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorio> findById(@PathVariable("id") Integer id) throws Exception {
        Consultorio obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
