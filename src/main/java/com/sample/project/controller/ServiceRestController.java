package com.sample.project.controller;

import com.sample.project.controller.dto.SampleDTO;
import com.sample.project.service.MyService;
import com.sample.project.service.repository.entity.SampleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ServiceRestController {

    private final MyService service;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ServiceRestController(MyService service) {
        this.service = service;
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<SampleDTO> getDTOById(@PathVariable Long id) {

        Optional<SampleEntity> entityById = service.getEntityById(id);

        if (entityById.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            SampleDTO sampleDTO = modelMapper.map(entityById, SampleDTO.class);

            return ResponseEntity.ok(sampleDTO);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<SampleDTO>> getAllSamples() {
        List<SampleEntity> allSamples = service.getAllSamples();

        List<SampleDTO> collect =
            allSamples.stream().map(sample -> modelMapper.map(sample, SampleDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(collect);
    }
}
