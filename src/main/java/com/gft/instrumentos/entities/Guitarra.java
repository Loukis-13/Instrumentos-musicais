package com.gft.instrumentos.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Guitarra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String corpo;
    private String cabeca;
    private String capitador1;
    private String capitador2;
    private String cor;
    private double preco;

    private String imagem;
}
