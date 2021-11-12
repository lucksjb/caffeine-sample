package com.example.caffeinesample.services;

import java.util.List;
import java.util.Optional;

import com.example.caffeinesample.DTOin.VendedorDTOin;
import com.example.caffeinesample.exceptions.VendedorNotFoundException;
import com.example.caffeinesample.models.Vendedor;
import com.example.caffeinesample.repositories.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;
    
    @Transactional
    public Vendedor create(VendedorDTOin vendedorDTOin) {
        Vendedor vendedor = new Vendedor();
        vendedor.setName(vendedorDTOin.getNome());
        return vendedorRepository.saveAndFlush(vendedor);
    }

    @Transactional
    public Vendedor update(VendedorDTOin vendedorDTOin, Long id) {
       Vendedor vendedor =  vendedorRepository.findById(id).orElseThrow(() -> new VendedorNotFoundException("Vendedor não cadastrado "));
       vendedor.setName(vendedorDTOin.getNome());
       return vendedorRepository.saveAndFlush(vendedor); 
    }

    @Transactional
    public void delete(Long id) {
        vendedorRepository.findById(id).orElseThrow(() -> new VendedorNotFoundException("Vendedor não cadastrado "));
        vendedorRepository.deleteById(id);
     }
 
     public Optional<Vendedor> findById(Long id) {
         return vendedorRepository.findById(id);
     }

     public List<Vendedor> findAll() {
         return vendedorRepository.findAll();
     }
}
