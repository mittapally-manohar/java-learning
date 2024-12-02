package org.consistent.practice.kafka;

import java.io.IOException;

public class StartKafka {

    public static void main(String[] args) {
        try {
            // Start Zookeeper
            ProcessBuilder zookeeperProcessBuilder = new ProcessBuilder("C:\\kafka\\kafka_2.13-3.9.0\\bin\\windows\\zookeeper-server-start.bat", "C:\\kafka\\kafka_2.13-3.9.0\\config\\zookeeper.properties");
            zookeeperProcessBuilder.inheritIO();  // This will show the output of the process in the console
            Process zookeeperProcess = zookeeperProcessBuilder.start();
            
            System.out.println("Zookeeper is starting...");

            // Wait for Zookeeper to start (you can adjust the waiting time as per your needs)
            Thread.sleep(5000);  // Wait for 5 seconds to ensure Zookeeper starts

            // Start Kafka Broker
            ProcessBuilder kafkaProcessBuilder = new ProcessBuilder("C:\\kafka\\kafka_2.13-3.9.0\\bin\\windows\\kafka-server-start.bat", "C:\\kafka\\kafka_2.13-3.9.0\\config\\server.properties");
            kafkaProcessBuilder.inheritIO();  // This will show the output of the process in the console
            Process kafkaProcess = kafkaProcessBuilder.start();

            System.out.println("Kafka Broker is starting...");
            
            // Wait for Kafka to start (you can adjust the waiting time as per your needs)
            Thread.sleep(5000);  // Wait for 5 seconds to ensure Kafka starts

            // Add your Kafka producer/consumer logic here after Kafka starts
            System.out.println("Kafka is up and running!");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
