package com.tr.cdb.vessel.location.collector;


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
	public static final String config = "cfg/collector.conf";
	public static final String logging = "cfg/logging.conf";
	
	public static String interval;
	public static String broker_list;
	public static String kafkatopic;
	public static String archivedir;
	public static String tickfile;

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

		interval = prop.getProperty("vtwebservice.callinginterval");
		broker_list = prop.getProperty("brokerlist");
		kafkatopic = prop.getProperty("kafkatopic");
		archivedir = prop.getProperty("archivedir");
		tickfile = prop.getProperty("tickfile");
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new VTWSCaller(tickfile,broker_list,kafkatopic), 0L, Long.parseLong(interval), TimeUnit.SECONDS);

	}


}
