//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.ibm.achievement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "isValidUserResponse", namespace = "http://service.achievement.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isValidUserResponse", namespace = "http://service.achievement.ibm.com/")
public class IsValidUserResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ibm.achievement.entity.EmployeeVO _return;

    /**
     * 
     * @return
     *     returns EmployeeVO
     */
    public com.ibm.achievement.entity.EmployeeVO getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ibm.achievement.entity.EmployeeVO _return) {
        this._return = _return;
    }

}