//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.ibm.achievement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAchievementById", namespace = "http://service.achievement.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAchievementById", namespace = "http://service.achievement.ibm.com/")
public class FindAchievementById {

    @XmlElement(name = "achievementId", namespace = "")
    private int achievementId;

    /**
     * 
     * @return
     *     returns int
     */
    public int getAchievementId() {
        return this.achievementId;
    }

    /**
     * 
     * @param achievementId
     *     the value for the achievementId property
     */
    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

}
