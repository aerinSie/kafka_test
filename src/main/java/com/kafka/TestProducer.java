package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TestProducer {
    public static void main(String[] args) {

        Properties prop = new Properties();
        prop.setProperty("bootstrap.servers", "localhost:9092");
        prop.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.setProperty("acks", "1");


        Producer<String, String> producer = new KafkaProducer<String, String>(prop);

        String topic = "test";
        String value = "hello kafka";



        ProducerRecord<String, String> record = new ProducerRecord<>(topic,value);
        producer.send(record);

        producer.close();
        System.out.println("sent ok");

    }
}


