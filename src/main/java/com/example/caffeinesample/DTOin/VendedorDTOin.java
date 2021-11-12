package com.example.caffeinesample.DTOin;

import javax.validation.constraints.NotBlank;

public class VendedorDTOin {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
