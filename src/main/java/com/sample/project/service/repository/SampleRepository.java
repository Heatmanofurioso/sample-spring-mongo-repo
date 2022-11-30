package com.sample.project.service.repository;

import com.sample.project.service.repository.entity.SampleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends MongoRepository<SampleEntity, Long> {

}
