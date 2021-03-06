package com.tr.cdb.vessel.location.type;

public class VesselLocation implements Comparable<Object>{

	public String coordinates;
	public String speed;
	public long recordtime;
	public String destination;
	public String previouslocation;
	public String nextlocation;
	
	
    public int compareTo(Object o) {
	if (this.recordtime > (((VesselLocation)o).recordtime))
	{
	    return 1;
	}
	else if (this.recordtime < (((VesselLocation)o).recordtime))
	{
	    return -1;
	}
	else
	{
	    return 0;	        	
	}
    }
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Long(recordtime).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		if (this.recordtime == (((VesselLocation)obj).recordtime))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
