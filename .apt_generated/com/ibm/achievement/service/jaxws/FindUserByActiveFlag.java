//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.ibm.achievement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findUserByActiveFlag", namespace = "http://service.achievement.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findUserByActiveFlag", namespace = "http://service.achievement.ibm.com/")
public class FindUserByActiveFlag {

    @XmlElement(name = "activeFlag", namespace = "")
    private String activeFlag;

    /**
     * 
     * @return
     *     returns String
     */
    public String getActiveFlag() {
        return this.activeFlag;
    }

    /**
     * 
     * @param activeFlag
     *     the value for the activeFlag property
     */
    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

}
