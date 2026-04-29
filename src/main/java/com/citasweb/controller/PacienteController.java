package com.citasweb.controller;

import com.citasweb.model.Paciente;
import com.citasweb.service.IPacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final IPacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) throws Exception {
        Paciente obj = service.save(paciente);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente, @PathVariable("id") Integer id) throws Exception {
        Paciente obj = service.update(paciente, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() throws Exception {
        List<Paciente> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") Integer id) throws Exception {
        Paciente obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
