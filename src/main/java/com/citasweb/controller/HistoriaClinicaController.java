package com.citasweb.controller;

import com.citasweb.model.HistoriaClinica;
import com.citasweb.service.IHistoriaClinicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias-clinicas")
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final IHistoriaClinicaService service;

    @PostMapping
    public ResponseEntity<HistoriaClinica> save(@RequestBody HistoriaClinica historiaClinica) throws Exception {
        HistoriaClinica obj = service.save(historiaClinica);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> update(@RequestBody HistoriaClinica historiaClinica, @PathVariable("id") Integer id) throws Exception {
        HistoriaClinica obj = service.update(historiaClinica, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> findAll() throws Exception {
        List<HistoriaClinica> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> findById(@PathVariable("id") Integer id) throws Exception {
        HistoriaClinica obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
