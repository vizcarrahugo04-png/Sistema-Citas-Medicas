package com.citasweb.controller;

import com.citasweb.model.Cita;
import com.citasweb.service.ICitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    private final ICitaService service;

    @PostMapping
    public ResponseEntity<Cita> save(@RequestBody Cita cita) throws Exception {
        Cita obj = service.save(cita);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> update(@RequestBody Cita cita, @PathVariable("id") Integer id) throws Exception {
        Cita obj = service.update(cita, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Cita>> findAll() throws Exception {
        List<Cita> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> findById(@PathVariable("id") Integer id) throws Exception {
        Cita obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
