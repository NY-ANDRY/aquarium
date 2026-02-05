package com.aquarium.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.services.PeriodService;
import com.aquarium.dto.aquarium.AquariumDTO;
import com.aquarium.dto.period.OkDTO;
import com.aquarium.dto.period.PeriodCreationDTO;
import com.aquarium.dto.period.PeriodDTO;
import com.aquarium.dto.period.PeriodEndDTO;
import com.aquarium.dto.period.PeriodFinancialDTO;
import com.aquarium.mappers.AquariumMapper;
import com.aquarium.mappers.PeriodMapper;
import com.aquarium.models.tables.Period;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/periods")
public class PeriodController {
    private final PeriodService periodService;
    private final PeriodMapper periodMapper;
    private final AquariumMapper aquariumMapper;

    @GetMapping("")
    public List<PeriodDTO> getAll() {
        return periodMapper.toDTOList(periodService.findAll());
    }

    @PostMapping("")
    public PeriodDTO create(@RequestBody PeriodCreationDTO dto) {
        Period period = periodMapper.toEntity(dto);
        Period saved = periodService.save(period);
        return periodMapper.toDTO(saved);
    }

    @GetMapping("/{id}")
    public PeriodDTO getOne(@PathVariable Long id) {
        Period p = periodService.findById(id);
        return periodMapper.toDTO(p);
    }

    @GetMapping("/{id}/summary")
    public PeriodFinancialDTO getSummary(@PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Period p = periodService.findById(id);

        double expense = 0;
        double income = 0;
        double benefit = 0;

        if (date != null) {
            expense = periodService.expense(p, date.atStartOfDay());
            income = periodService.income(p, date.atStartOfDay());
            benefit = income - expense;
        } else {
            expense = periodService.expense(p, null);
            income = periodService.income(p, null);
            benefit = income - expense;
        }

        if (p == null || p.getEnd() == null) {
            return periodMapper.toSummaryDTO(expense, income, benefit, false);
        }

        return periodMapper.toSummaryDTO(expense, income, benefit, true);
    }

    @GetMapping("/{id}/aquariums")
    public List<AquariumDTO> getAquariums(@PathVariable Long id) {
        Period p = periodService.findById(id);
        return aquariumMapper.toDTOList(p.getAquariums());
    }

    @PostMapping("/{id}/end")
    public OkDTO end(@PathVariable Long id, @RequestBody PeriodEndDTO end) {
        Period p = periodService.findById(id);

        LocalDate endDate = end.end();
        LocalDateTime end_date = endDate.atStartOfDay();

        periodService.process(p, end_date);
        return periodMapper.ok(p.getId().intValue());
    }
}
