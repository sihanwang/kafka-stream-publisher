
package com.tr.cdb.vessel.location.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NoPermissionException", targetNamespace = "http://webservice.vesseltracker.com/")
public class NoPermissionException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NoPermissionException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoPermissionException_Exception(String message, NoPermissionException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NoPermissionException_Exception(String message, NoPermissionException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.tr.cdb.vessel.location.ws.NoPermissionException
     */
    public NoPermissionException getFaultInfo() {
        return faultInfo;
    }

}
