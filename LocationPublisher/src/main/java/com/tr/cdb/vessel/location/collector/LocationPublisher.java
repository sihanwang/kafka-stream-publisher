package com.tr.cdb.vessel.location.collector;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class LocationPublisher {
	private Producer<String, String> producer;
	private String broker_list;
	private String location_topic;

	public LocationPublisher(String brokerlist, String topic) {
		broker_list = brokerlist;
		location_topic = topic;
	}

	public void init_producer() {
		try {
			Properties props = new Properties();
			props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker_list);
			props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.StringSerializer");
			props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.StringSerializer");
			props.put("partitioner.class", "com.tr.cdb.vessel.location.collector.ShipIDPartitioner");
			props.put(ProducerConfig.ACKS_CONFIG, "1");

			producer = new KafkaProducer<String, String>(props);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void publish(int ship_id, String location) {

		// Creates a KeyedMessage instance
		ProducerRecord<String, String> record = new ProducerRecord<>(location_topic, String.valueOf(ship_id), location);
		// Publish the message
		Future<RecordMetadata> result = producer.send(record, new ProducerCallback());
		
		System.out.println("sent:" + location);

	}

	public void close_producer() {
		// Close producer connection with broker.
		producer.close();
		producer = null;
	}

	private class ProducerCallback implements Callback {
		@Override
		public void onCompletion(RecordMetadata rm, Exception e) {
			if (e != null) {
				e.printStackTrace();
			}
			else if (rm != null)
			{
				System.out.println("Topic:" + rm.topic()+"|"+"Offset:" + rm.offset()+"|"+"Partition number:" + rm.partition());
			}
		}
	}
}
