package org.consistent.practice.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;
import java.util.Collections;

public class ShipmentConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "shipment-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("payment"));

        while (true) {
            consumer.poll(100).forEach(record -> {
                // Process shipment logic here
                String paymentStatus = record.value();
                System.out.println("Processing shipment for: " + paymentStatus);
                
                // Simulating shipment processing
                String shipmentStatus = "Shipment for " + paymentStatus + " dispatched";

                // Publish shipment event to Kafka
                new ShipmentProducer().sendToShipmentTopic(shipmentStatus);
            });
        }
    }
}
