package com.citasweb.controller;

import com.citasweb.model.Pago;
import com.citasweb.service.IPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final IPagoService service;

    @PostMapping
    public ResponseEntity<Pago> save(@RequestBody Pago pago) throws Exception {
        Pago obj = service.save(pago);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(@RequestBody Pago pago, @PathVariable("id") Integer id) throws Exception {
        Pago obj = service.update(pago, id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> findAll() throws Exception {
        List<Pago> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> findById(@PathVariable("id") Integer id) throws Exception {
        Pago obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

