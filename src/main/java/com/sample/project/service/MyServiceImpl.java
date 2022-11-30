package com.sample.project.service;

import com.sample.project.service.repository.SampleRepository;
import com.sample.project.service.repository.entity.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyServiceImpl implements MyService {

    private final SampleRepository repository;

    @Autowired
    public MyServiceImpl(SampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createEntity(SampleEntity sample) {
        repository.save(sample);
    }

    @Override
    public Optional<SampleEntity> getEntityById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SampleEntity> getAllSamples() {
        return repository.findAll();
    }
}
