package com.example.zup.diary.service;

import com.example.zup.diary.controllers.DTO.ZupDiaryDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ZupDiaryService {

    private final List<ZupDiaryDTO> events = new ArrayList<>();

    public ZupDiaryDTO createEvent(ZupDiaryDTO zupDiaryDTO) {
        zupDiaryDTO.setId(UUID.randomUUID().toString());
        events.add(zupDiaryDTO);
        return zupDiaryDTO;
    }

   public List<ZupDiaryDTO> getEventsByDays(int days) {
    LocalDate today = LocalDate.now();
    if (days >= 0) {
        return events.stream()
                .filter(event -> !event.getDataInicio().isBefore(today) && !event.getDataInicio().isAfter(today.plusDays(days)))
                .collect(Collectors.toList());
    } else {
        return events.stream()
                .filter(event -> !event.getDataFim().isAfter(today) && !event.getDataFim().isBefore(today.minusDays(Math.abs(days))))
                .collect(Collectors.toList());
    }
}

    public void deleteEvent(String id) {
        events.removeIf(event -> event.getId().equals(id));
    }

    public Optional<ZupDiaryDTO>  cancelEvent(String id) {
        Optional<ZupDiaryDTO> eventOptional = events.stream().filter(event -> event.getId().equals(id)).findFirst();
        eventOptional.ifPresent(event -> event.setEventoAtivo(false));
        return eventOptional;
    }

    public List<ZupDiaryDTO> getFutureEvents() {
        return events.stream().filter(event -> event.getDataInicio().isAfter(LocalDate.now())).collect(Collectors.toList());
    }
    public List<ZupDiaryDTO> filterEventsByStatus(List<ZupDiaryDTO> events, boolean ativos) {
        return events.stream()
                .filter(event -> event.isEventoAtivo() == ativos)
                .collect(Collectors.toList());
    }

}
