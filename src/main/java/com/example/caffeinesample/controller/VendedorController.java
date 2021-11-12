package com.example.caffeinesample.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.example.caffeinesample.DTOin.VendedorDTOin;
import com.example.caffeinesample.models.Vendedor;
import com.example.caffeinesample.services.VendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    private VendedorService vendedorService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> findById(@PathParam("id") Long id) {
        Optional<Vendedor> vendedor = vendedorService.findById(id);
        return vendedor.isPresent()? ResponseEntity.ok().body(vendedor.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> findByAll() {
        return ResponseEntity.ok().body(vendedorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Vendedor>  create(@Validated @RequestBody VendedorDTOin vendedorDTOin) {
        return ResponseEntity.ok().body(vendedorService.create(vendedorDTOin));
    }
    
    @PutMapping("/{id}")
    public  ResponseEntity<Vendedor>  update(@PathVariable Long id, @Validated @RequestBody VendedorDTOin vendedorDTOin) {
        return ResponseEntity.ok().body(vendedorService.update(vendedorDTOin, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        vendedorService.delete(id);
    }
}
