package com.example.zup.diary.controllers;

import com.example.zup.diary.controllers.DTO.ZupDiaryDTO;
import com.example.zup.diary.service.ZupDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class ZupDiaryController {


    @Autowired
    private ZupDiaryService zupDiaryService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody ZupDiaryDTO zupDiaryDTO) {
        if (zupDiaryDTO.getNomeEvento()== null || zupDiaryDTO.getDescricao() == null || zupDiaryDTO.getDataInicio() == null || zupDiaryDTO.getDataFim() == null || zupDiaryDTO.getHoraInicio() == null || zupDiaryDTO.getHoraFim() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("All fields are required.");
        }
        ZupDiaryDTO createdEvent = zupDiaryService.createEvent(zupDiaryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }


    @GetMapping
    public ResponseEntity<List<ZupDiaryDTO>> getEvents(
        @RequestParam(required = false) Integer dias,
        @RequestParam(required = false) Boolean ativos) {

    List<ZupDiaryDTO> events;

        if (dias != null) {
            events = zupDiaryService.getEventsByDays(dias);
        } else {
            events = zupDiaryService.getFutureEvents();
        }
        if (ativos != null) {
            events = zupDiaryService.filterEventsByStatus(events, ativos);
        }

    return ResponseEntity.ok(events);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id) {
        zupDiaryService.deleteEvent(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<?> cancelEvent(@PathVariable String id) {
        Optional<ZupDiaryDTO> cancelledEvent = zupDiaryService.cancelEvent(id);
        return cancelledEvent.isPresent() ? ResponseEntity.ok(cancelledEvent.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
    }
}
