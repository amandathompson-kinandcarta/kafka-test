package com.kafkatest.event.model.repository;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollment_queue")
public class EnrollmentEntity {

    @Id
    @Column(name = "queue_id")
    private Long queueId;

    @Column(name = "acct_key")
    private String acctKey;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

}
