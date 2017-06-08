package com.tr.cdb.vessel.location.distributor;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import kafka.common.OffsetAndMetadata;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;


public class LocationConsumer2 {
	
	private final KafkaConsumer<String, String> consumer;
	private String location_topic;

	
    public LocationConsumer2(String broker_list, String a_groupId, String a_topic) {
    	location_topic = a_topic;
    	consumer = createConsumerConfig(broker_list, a_groupId);        
    }

	
    private KafkaConsumer<String, String> createConsumerConfig(String broker_list, String a_groupId) {
    	Properties props = new Properties();
    	props.put("bootstrap.servers", broker_list);
    	props.put("group.id", a_groupId);
    	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    	props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    	props.put("partition.assignment.strategy","range");
    	KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
    	consumer.subscribe(location_topic);
        return consumer;
    }
 	
	public void run() {
		Map<TopicPartition, Long> currentOffsets=new HashMap<TopicPartition, Long>();
		int count = 0;

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100).get(location_topic);
				
				for (ConsumerRecord<String, String> record : records.records()) {
					System.out.println("topic = "+record.topic()+" partition = "+record.partition()+" offset = " +record.offset() + " key =	"+record.key()+" value = "+ record.value());
					
					currentOffsets.put(new TopicPartition(record.topic(), record.partition()), record.offset());
					
					if (count % 1000 == 0)
						consumer.commit(currentOffsets, false);
					count++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
