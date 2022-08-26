package com.kafkatest.event;

import com.kafkatest.event.model.repository.EnrollmentEntity;
import com.kafkatest.event.producer.KafkaEventProducer;
import com.kafkatest.event.repository.EnrollmentRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    EnrollmentRepository enrollmentRepository;
    KafkaEventProducer kafkaEventProducer;

    @Value("${spring.kafka.consumer.sender-topic}")
    private String senderTopic;

    public DataService(EnrollmentRepository enrollmentRepository, KafkaEventProducer kafkaEventProducer) {
        this.enrollmentRepository = enrollmentRepository;
        this.kafkaEventProducer = kafkaEventProducer;
    }

    public void sendUpdates() {
        List<EnrollmentEntity> updates = enrollmentRepository.findAll();
        JSONArray updateArray = new JSONArray();

        for (EnrollmentEntity dataEntity : updates) {
            JSONObject update = new JSONObject(dataEntity);
            updateArray.put(update);
        }

        kafkaEventProducer.sendMessage(updateArray.toString(), senderTopic);
        System.out.println("=============Sending updates....===============");
    }
}
