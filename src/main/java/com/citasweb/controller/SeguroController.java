package com.citasweb.controller;

import com.citasweb.model.Seguro;
import com.citasweb.service.ISeguroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
@RequiredArgsConstructor
public class SeguroController {

    private final ISeguroService service;

    @PostMapping
    public ResponseEntity<Seguro> save(@RequestBody Seguro seguro) throws Exception {
        Seguro obj = service.save(seguro);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seguro> update(@RequestBody Seguro seguro, @PathVariable("id") Integer id) throws Exception {
        Seguro obj = service.update(seguro, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Seguro>> findAll() throws Exception {
        List<Seguro> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seguro> findById(@PathVariable("id") Integer id) throws Exception {
        Seguro obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
