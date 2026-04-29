package com.citasweb.controller;

import com.citasweb.model.Administrador;
import com.citasweb.service.IAdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final IAdministradorService service;

    @PostMapping
    public ResponseEntity<Administrador> save(@RequestBody Administrador administrador) throws Exception {
        Administrador obj = service.save(administrador);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> update(@RequestBody Administrador administrador, @PathVariable("id") Integer id) throws Exception {
        Administrador obj = service.update(administrador, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> findAll() throws Exception {
        List<Administrador> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> findById(@PathVariable("id") Integer id) throws Exception {
        Administrador obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
