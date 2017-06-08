package com.tr.cdb.vessel.location.collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.tr.cdb.vessel.location.ws.AccountLockedException_Exception;
import com.tr.cdb.vessel.location.ws.BadFormatException_Exception;
import com.tr.cdb.vessel.location.ws.GlobalSatExport;
import com.tr.cdb.vessel.location.ws.GlobalSatExportService;
import com.tr.cdb.vessel.location.ws.GlobalSatExportShipInfo;
import com.tr.cdb.vessel.location.ws.GlobalSatExportValue;
import com.tr.cdb.vessel.location.ws.IncorrectPasswordException_Exception;
import com.tr.cdb.vessel.location.ws.NoPermissionException_Exception;
import com.tr.cdb.vessel.location.ws.UserNotFoundException_Exception;

import net.sf.json.JSONObject;

public class VTWSCaller implements Runnable {

	private String tickfilepath;
	private String brokerlist;
	private String kafkatopic;

	public VTWSCaller(String path, String broker_list, String kafka_topic) {
		tickfilepath = path;
		brokerlist = broker_list;
		kafkatopic = kafka_topic;
	}

	public void run() {

		LocationPublisher LP=new LocationPublisher(brokerlist,kafkatopic);
		LP.init_producer();

		GlobalSatExportService GSES = new GlobalSatExportService();
		GlobalSatExport GSE = GSES.getGlobalSatExportPort();
		try {
			
			
			GlobalSatExportValue GSEV = GSE.exportGlobalSatData("thomsonreutersprod", "9gr39j",
					convertToXMLGregorianCalendar(readTick()));
			List<GlobalSatExportShipInfo> VesselLocationList = GSEV.getVessel();
			
			VesselLocationList.forEach(gsesi -> {
				JSONObject jsonPosition = new JSONObject(); 
				jsonPosition.put("shipId", gsesi.getShipId());
				jsonPosition.put("SMmsi", gsesi.getSMmsi());
				jsonPosition.put("SName", gsesi.getSName());
				jsonPosition.put("SImo", gsesi.getSImo());
				jsonPosition.put("SLength", gsesi.getSLength());
				jsonPosition.put("SWidth", gsesi.getSWidth());
				jsonPosition.put("SShiptype", gsesi.getSShiptype());
				jsonPosition.put("SCallsign", gsesi.getSCallsign());
				
				if (gsesi.getPTime()!=null)
				{
					jsonPosition.put("PTime", new DateTime(gsesi.getPTime().toGregorianCalendar().getTime()).withZone(DateTimeZone.UTC).toString(Starter.generaldateformatter));
				}
				
				
				jsonPosition.put("PLat", gsesi.getPLat());
				jsonPosition.put("PLong", gsesi.getPLong());
				jsonPosition.put("PSpeed", gsesi.getPSpeed());
				jsonPosition.put("PStatus", gsesi.getPStatus());
				jsonPosition.put("PStatusVt", gsesi.getPStatusVt());
				jsonPosition.put("PSource", gsesi.getPSource());
				jsonPosition.put("PHdg", gsesi.getPHdg());
				jsonPosition.put("PCourse", gsesi.getPCourse());
				
				jsonPosition.put("VDest", gsesi.getVDest());
				jsonPosition.put("VDestCleaned", gsesi.getVDestCleaned());
				jsonPosition.put("VDestLocode", gsesi.getVDestLocode());
				jsonPosition.put("VDraught", gsesi.getVDraught());
				
				if (gsesi.getVEta()!=null)
				{
					jsonPosition.put("VEta", new DateTime(gsesi.getVEta().toGregorianCalendar().getTime()).withZone(DateTimeZone.UTC).toString(Starter.generaldateformatter));
				}
				
				
				jsonPosition.put("VSource", gsesi.getVSource());
				
				if (gsesi.getVTime()!=null)
				{
					jsonPosition.put("VTime", new DateTime(gsesi.getVTime().toGregorianCalendar().getTime()).withZone(DateTimeZone.UTC).toString(Starter.generaldateformatter));
				}
				
				LP.publish(gsesi.getShipId(), jsonPosition.toString());
				
			});
			
			LP.close_producer();
			
			wirteTick(GSEV.getTimeCreated().toGregorianCalendar().getTime().getTime());


		} catch (AccountLockedException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadFormatException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectPasswordException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoPermissionException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public XMLGregorianCalendar convertToXMLGregorianCalendar(long date) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(date));
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return gc;
	}

	public long readTick() throws IOException {

		File file = new File(tickfilepath);

		if (file.isFile() && file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String lastcalltime = br.readLine();
			br.close();
			return DateTime.parse(lastcalltime.trim(), Starter.generaldateformatter).withZone(DateTimeZone.UTC)
					.getMillis();
		} else {
			return new DateTime().minusMinutes(15).getMillis();
		}
	}

	public void wirteTick(long tick) throws IOException {

		String lastcalltime = new DateTime(tick).withZone(DateTimeZone.UTC).toString(Starter.generaldateformatter);
		File file = new File(tickfilepath);
		FileWriter fw = new FileWriter(file);
		fw.write(lastcalltime);
		fw.close();
	}
}
