package com.ernandes.neponuceno.codetickets;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Importacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String cpf;
    private String cliente;
    private LocalDate nascimento;
    private String evento;
    private LocalDate data;
    private String tipoIngresso;
    private Double valor;
    private LocalDateTime horaImportacao;
    private Double taxaAdm;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getHoraImportacao() {
        return horaImportacao;
    }

    public void setHoraImportacao(LocalDateTime horaImportacao) {
        this.horaImportacao = horaImportacao;
    }

    public Double getTaxaAdm() {
        return taxaAdm;
    }

    public void setTaxaAdm(Double taxaAdm) {
        this.taxaAdm = taxaAdm;
    }

}
