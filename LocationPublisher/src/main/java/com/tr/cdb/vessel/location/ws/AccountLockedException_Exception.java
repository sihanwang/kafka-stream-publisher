
package com.tr.cdb.vessel.location.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AccountLockedException", targetNamespace = "http://webservice.vesseltracker.com/")
public class AccountLockedException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AccountLockedException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AccountLockedException_Exception(String message, AccountLockedException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AccountLockedException_Exception(String message, AccountLockedException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.tr.cdb.vessel.location.ws.AccountLockedException
     */
    public AccountLockedException getFaultInfo() {
        return faultInfo;
    }

}