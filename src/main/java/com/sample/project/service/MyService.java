package com.sample.project.service;

import com.sample.project.service.repository.entity.SampleEntity;

import java.util.List;
import java.util.Optional;

public interface MyService {

    void createEntity(SampleEntity sample);

    Optional<SampleEntity> getEntityById(Long id);

    List<SampleEntity> getAllSamples();
}
