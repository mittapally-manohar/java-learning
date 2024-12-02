package org.consistent.practice.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {
    public static void main(String[] args) {
        // Set the properties for the consumer
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Kafka broker
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group"); // Consumer group
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Create the consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the "test" topic
        consumer.subscribe(Collections.singletonList("test"));

        // Poll for new messages and consume them
        while (true) {
            org.apache.kafka.clients.consumer.ConsumerRecords<String, String> records = consumer.poll(1000); // 1 second timeout
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Consumed message: " + record.value());
            }
        }
    }
}
