-- noinspection SqlNoDataSourceInspectionForFile
DROP TABLE IF EXISTS enrollment_queue;
CREATE TABLE enrollment_queue
(
    queue_id SERIAL PRIMARY KEY,
    acct_key VARCHAR(10),
    start_date BIGINT,
    end_date BIGINT
);

INSERT INTO enrollment_queue (queue_id, acct_key, start_date, end_date) VALUES (1, 123456789, 1344282960000, 1661543756846);