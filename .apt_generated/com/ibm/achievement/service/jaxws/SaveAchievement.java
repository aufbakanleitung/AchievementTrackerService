//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package com.ibm.achievement.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "saveAchievement", namespace = "http://service.achievement.ibm.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveAchievement", namespace = "http://service.achievement.ibm.com/")
public class SaveAchievement {

    @XmlElement(name = "achievementVO", namespace = "")
    private com.ibm.achievement.entity.AchievementVO achievementVO;

    /**
     * 
     * @return
     *     returns AchievementVO
     */
    public com.ibm.achievement.entity.AchievementVO getAchievementVO() {
        return this.achievementVO;
    }

    /**
     * 
     * @param achievementVO
     *     the value for the achievementVO property
     */
    public void setAchievementVO(com.ibm.achievement.entity.AchievementVO achievementVO) {
        this.achievementVO = achievementVO;
    }

}