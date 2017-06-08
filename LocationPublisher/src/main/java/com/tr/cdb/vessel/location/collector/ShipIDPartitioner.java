package com.tr.cdb.vessel.location.collector;

import kafka.producer.Partitioner;

public class ShipIDPartitioner implements Partitioner {
	


	/*
	 * The method takes the key, which in this case is the IP address, It finds
	 * the last octet and does a modulo operation on the number of partitions
	 * defined within Kafka for the topic.
	 *
	 * @see kafka.producer.Partitioner#partition(java.lang.Object, int)
	 */
	public int partition(Object key, int a_numPartitions) {
		int ShipID= Integer.parseInt((String)key);
		return ShipID%a_numPartitions;
	}


}
