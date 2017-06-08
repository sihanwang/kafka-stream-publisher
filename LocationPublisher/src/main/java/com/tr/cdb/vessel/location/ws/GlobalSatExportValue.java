
package com.tr.cdb.vessel.location.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for globalSatExportValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="globalSatExportValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vessel" type="{http://webservice.vesseltracker.com/}globalSatExportShipInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="timeCreated" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalSatExportValue", propOrder = {
    "vessel"
})
public class GlobalSatExportValue {

    @XmlElement(required = true)
    protected List<GlobalSatExportShipInfo> vessel;
    @XmlAttribute(name = "timeCreated", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeCreated;

    /**
     * Gets the value of the vessel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vessel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVessel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlobalSatExportShipInfo }
     * 
     * 
     */
    public List<GlobalSatExportShipInfo> getVessel() {
        if (vessel == null) {
            vessel = new ArrayList<GlobalSatExportShipInfo>();
        }
        return this.vessel;
    }

    /**
     * Gets the value of the timeCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeCreated() {
        return timeCreated;
    }

    /**
     * Sets the value of the timeCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeCreated(XMLGregorianCalendar value) {
        this.timeCreated = value;
    }

}
