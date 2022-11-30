package com.sample.project;

import com.sample.project.service.repository.SampleRepository;
import com.sample.project.service.repository.entity.SampleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MongoIT extends AbstractMongoIntegrationTest {

    @Autowired
    private SampleRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @DisplayName("""
        Given a repository with data
        When we attempt to add data
        It should be added without any issues
        """)
    @Test
    void testGetAll() {

        Assertions.assertTrue(repository.findAll().isEmpty());

        SampleEntity sample = new SampleEntity();
        sample.setId(2L);
        repository.save(sample);

        Assertions.assertFalse(repository.findAll().isEmpty());
    }
}
