package com.kafkatest.event.consumer;

import com.kafkatest.event.DataService;
import com.kafkatest.event.repository.EnrollmentRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventConsumer {

    EnrollmentRepository enrollmentRepository;
    DataService dataService;

    public KafkaEventConsumer(EnrollmentRepository enrollmentRepository, DataService dataService) {
        this.enrollmentRepository = enrollmentRepository;
        this.dataService = dataService;
    }

    @KafkaListener(topics = "event-topic", groupId = "eventGroup")
    void listener() {
        //start process
        dataService.sendUpdates();
    }
}
