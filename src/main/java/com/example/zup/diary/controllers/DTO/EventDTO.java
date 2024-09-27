package com.example.zup.diary.controllers.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {
    private String id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String nomeEvento;
    private String descricao;
    private boolean eventoAtivo;

    public EventDTO() {}

    public EventDTO(String id, LocalDate dataInicio, LocalDate dataFim, LocalTime horaInicio, LocalTime horaFim, String nomeEvento, String descricao, boolean eventoAtivo) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.eventoAtivo = eventoAtivo;
}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalTime getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isEventoAtivo() {
        return eventoAtivo;
    }
    public void setEventoAtivo(boolean eventoAtivo) {
        this.eventoAtivo = eventoAtivo;
    }

}
