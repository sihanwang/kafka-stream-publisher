package com.tr.cdb.vessel.location.distributor;


import java.io.FileInputStream;


import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import java.util.concurrent.Executors;

import org.apache.log4j.PropertyConfigurator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class Starter {

	public final static String GENERAL_DATE_FORMAT_SSS = "yyyyMMddHHmmss";
	public final static DateTimeFormatter generaldateformatter = DateTimeFormat.forPattern(GENERAL_DATE_FORMAT_SSS)
			.withZoneUTC();
	public static final String config = "cfg/distributor.conf";
	public static final String logging = "cfg/logging.conf";
	
	public static String zookeeperlist;
	public static String kafkatopic;
	public static String groupid;



	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		PropertyConfigurator.configure(logging);
		
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(config);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Can't read configuration file: " + config);
		}

		
		zookeeperlist = prop.getProperty("zookeeperlist");
		kafkatopic = prop.getProperty("kafkatopic");
		groupid = prop.getProperty("groupid");
	
		LocationConsumer LC = new LocationConsumer(zookeeperlist,groupid,kafkatopic);
		LC.run(1);
		//LocationConsumer2 LC2 = new LocationConsumer2(zookeeperlist,groupid,kafkatopic);
		//LC2.run();

	}


}
