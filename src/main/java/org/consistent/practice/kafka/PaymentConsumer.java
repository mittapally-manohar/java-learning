package org.consistent.practice.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;
import java.util.Collections;

public class PaymentConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "payment-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("orders"));

        while (true) {
            consumer.poll(100).forEach(record -> {
                // Process payment logic here
                String order = record.value();
                System.out.println("Processing payment for: " + order);
                
                // Simulating payment processing
                String paymentStatus = "Payment for " + order + " processed successfully";

                // Publish payment event to Kafka
                // (Assume PaymentProducer is similar to the OrderProducer in structure)
//                new PaymentProducer().sendToPaymentTopic(paymentStatus);
            });
        }
    }
}
