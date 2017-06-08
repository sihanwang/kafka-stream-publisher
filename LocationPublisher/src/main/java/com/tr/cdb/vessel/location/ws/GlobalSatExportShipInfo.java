
package com.tr.cdb.vessel.location.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for globalSatExportShipInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="globalSatExportShipInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="shipId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sImo" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="sMmsi" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="sCallsign" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sShiptype" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="sLength" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="sWidth" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="sName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vDraught" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="vDest" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vDestCleaned" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vDestLocode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vEta" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="vTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="vSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pLong" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="pLat" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="pHdg" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="pSpeed" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="pStatus" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="pStatusVt" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="pTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="pCourse" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="pSource" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalSatExportShipInfo")
public class GlobalSatExportShipInfo {

    @XmlAttribute(name = "shipId", required = true)
    protected int shipId;
    @XmlAttribute(name = "sImo")
    protected Long sImo;
    @XmlAttribute(name = "sMmsi")
    protected Long sMmsi;
    @XmlAttribute(name = "sCallsign")
    protected String sCallsign;
    @XmlAttribute(name = "sShiptype")
    protected Long sShiptype;
    @XmlAttribute(name = "sLength")
    protected Double sLength;
    @XmlAttribute(name = "sWidth")
    protected Double sWidth;
    @XmlAttribute(name = "sName")
    protected String sName;
    @XmlAttribute(name = "vDraught")
    protected Double vDraught;
    @XmlAttribute(name = "vDest")
    protected String vDest;
    @XmlAttribute(name = "vDestCleaned")
    protected String vDestCleaned;
    @XmlAttribute(name = "vDestLocode")
    protected String vDestLocode;
    @XmlAttribute(name = "vEta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vEta;
    @XmlAttribute(name = "vTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar vTime;
    @XmlAttribute(name = "vSource")
    protected String vSource;
    @XmlAttribute(name = "pLong")
    protected Double pLong;
    @XmlAttribute(name = "pLat")
    protected Double pLat;
    @XmlAttribute(name = "pHdg")
    protected Double pHdg;
    @XmlAttribute(name = "pSpeed")
    protected Double pSpeed;
    @XmlAttribute(name = "pStatus")
    protected Long pStatus;
    @XmlAttribute(name = "pStatusVt")
    protected Long pStatusVt;
    @XmlAttribute(name = "pTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pTime;
    @XmlAttribute(name = "pCourse")
    protected Double pCourse;
    @XmlAttribute(name = "pSource")
    protected String pSource;

    /**
     * Gets the value of the shipId property.
     * 
     */
    public int getShipId() {
        return shipId;
    }

    /**
     * Sets the value of the shipId property.
     * 
     */
    public void setShipId(int value) {
        this.shipId = value;
    }

    /**
     * Gets the value of the sImo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSImo() {
        return sImo;
    }

    /**
     * Sets the value of the sImo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSImo(Long value) {
        this.sImo = value;
    }

    /**
     * Gets the value of the sMmsi property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSMmsi() {
        return sMmsi;
    }

    /**
     * Sets the value of the sMmsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSMmsi(Long value) {
        this.sMmsi = value;
    }

    /**
     * Gets the value of the sCallsign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCallsign() {
        return sCallsign;
    }

    /**
     * Sets the value of the sCallsign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCallsign(String value) {
        this.sCallsign = value;
    }

    /**
     * Gets the value of the sShiptype property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSShiptype() {
        return sShiptype;
    }

    /**
     * Sets the value of the sShiptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSShiptype(Long value) {
        this.sShiptype = value;
    }

    /**
     * Gets the value of the sLength property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSLength() {
        return sLength;
    }

    /**
     * Sets the value of the sLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSLength(Double value) {
        this.sLength = value;
    }

    /**
     * Gets the value of the sWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSWidth() {
        return sWidth;
    }

    /**
     * Sets the value of the sWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSWidth(Double value) {
        this.sWidth = value;
    }

    /**
     * Gets the value of the sName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSName() {
        return sName;
    }

    /**
     * Sets the value of the sName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSName(String value) {
        this.sName = value;
    }

    /**
     * Gets the value of the vDraught property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVDraught() {
        return vDraught;
    }

    /**
     * Sets the value of the vDraught property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVDraught(Double value) {
        this.vDraught = value;
    }

    /**
     * Gets the value of the vDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDest() {
        return vDest;
    }

    /**
     * Sets the value of the vDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDest(String value) {
        this.vDest = value;
    }

    /**
     * Gets the value of the vDestCleaned property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDestCleaned() {
        return vDestCleaned;
    }

    /**
     * Sets the value of the vDestCleaned property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDestCleaned(String value) {
        this.vDestCleaned = value;
    }

    /**
     * Gets the value of the vDestLocode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDestLocode() {
        return vDestLocode;
    }

    /**
     * Sets the value of the vDestLocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDestLocode(String value) {
        this.vDestLocode = value;
    }

    /**
     * Gets the value of the vEta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVEta() {
        return vEta;
    }

    /**
     * Sets the value of the vEta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVEta(XMLGregorianCalendar value) {
        this.vEta = value;
    }

    /**
     * Gets the value of the vTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVTime() {
        return vTime;
    }

    /**
     * Sets the value of the vTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVTime(XMLGregorianCalendar value) {
        this.vTime = value;
    }

    /**
     * Gets the value of the vSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVSource() {
        return vSource;
    }

    /**
     * Sets the value of the vSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVSource(String value) {
        this.vSource = value;
    }

    /**
     * Gets the value of the pLong property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPLong() {
        return pLong;
    }

    /**
     * Sets the value of the pLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPLong(Double value) {
        this.pLong = value;
    }

    /**
     * Gets the value of the pLat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPLat() {
        return pLat;
    }

    /**
     * Sets the value of the pLat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPLat(Double value) {
        this.pLat = value;
    }

    /**
     * Gets the value of the pHdg property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPHdg() {
        return pHdg;
    }

    /**
     * Sets the value of the pHdg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPHdg(Double value) {
        this.pHdg = value;
    }

    /**
     * Gets the value of the pSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPSpeed() {
        return pSpeed;
    }

    /**
     * Sets the value of the pSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPSpeed(Double value) {
        this.pSpeed = value;
    }

    /**
     * Gets the value of the pStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPStatus() {
        return pStatus;
    }

    /**
     * Sets the value of the pStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPStatus(Long value) {
        this.pStatus = value;
    }

    /**
     * Gets the value of the pStatusVt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPStatusVt() {
        return pStatusVt;
    }

    /**
     * Sets the value of the pStatusVt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPStatusVt(Long value) {
        this.pStatusVt = value;
    }

    /**
     * Gets the value of the pTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPTime() {
        return pTime;
    }

    /**
     * Sets the value of the pTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPTime(XMLGregorianCalendar value) {
        this.pTime = value;
    }

    /**
     * Gets the value of the pCourse property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPCourse() {
        return pCourse;
    }

    /**
     * Sets the value of the pCourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPCourse(Double value) {
        this.pCourse = value;
    }

    /**
     * Gets the value of the pSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPSource() {
        return pSource;
    }

    /**
     * Sets the value of the pSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPSource(String value) {
        this.pSource = value;
    }

}
