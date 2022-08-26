package com.kafkatest.event.repository;

import com.kafkatest.event.model.repository.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
