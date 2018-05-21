package net.javabeat.spring.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Statistic implements Serializable{
    @Id
    long id;
    @Column(name="methodName")
    private String methodName;
    @Column(name="openTime")
    private int openTime;

    public long getId() {
        return id;
    }

    public String getMethodName() {
        return methodName;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }
}
