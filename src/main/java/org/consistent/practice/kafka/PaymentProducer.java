package org.consistent.practice.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class PaymentProducer {
    
    // Kafka producer properties
    private static KafkaProducer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    // Method to send a message to the payment topic
    private static void sendToPaymentTopic(KafkaProducer<String, String> producer, String message, String key) {
        producer.send(new ProducerRecord<>("payment", key, message));
        System.out.println("Sent payment event: " + message);
    }

    public static void main(String[] args) {
        // Create the producer
        KafkaProducer<String, String> producer = createProducer();

        // Send payment events to Kafka using the sendToPaymentTopic method
        for (int i = 0; i < 5; i++) {
            String paymentMessage = "Payment for Order " + i + " processed"; 
            sendToPaymentTopic(producer, paymentMessage, Integer.toString(i)); // Call sendToPaymentTopic
        }

        // Close the producer
        producer.close();
    }
}
