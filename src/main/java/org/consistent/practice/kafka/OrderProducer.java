package org.consistent.practice.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class OrderProducer {
    public static void main(String[] args) {
        // Set Kafka Producer properties
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Send order event
        for (int i = 0; i < 5; i++) {
            String orderMessage = "Order " + i + " placed";
            producer.send(new ProducerRecord<>("orders", Integer.toString(i), orderMessage));
            System.out.println("Sent order event: " + orderMessage);
        }

        // Close producer
        producer.close();
    }
}
