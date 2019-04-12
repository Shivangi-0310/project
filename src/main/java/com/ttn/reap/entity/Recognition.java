package com.ttn.reap.entity;


import com.ttn.reap.enums.Badge;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recognition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    Employee recognizerId;

    @OneToOne
    Employee recognizeeId;

    private String message;

    @Temporal(TemporalType.DATE)
    private Date dateOfRecognition;

    @Enumerated(EnumType.STRING)
    private Badge badge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getRecognizerId() {
        return recognizerId;
    }

    public void setRecognizerId(Employee recognizerId) {
        this.recognizerId = recognizerId;
    }

    public Employee getRecognizeeId() {
        return recognizeeId;
    }

    public void setRecognizeeId(Employee recognizeeId) {
        this.recognizeeId = recognizeeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateOfRecognition() {
        return dateOfRecognition;
    }

    public void setDateOfRecognition(Date dateOfRecognition) {
        this.dateOfRecognition = dateOfRecognition;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Recognition() {
    }

    @Override
    public String toString() {
        return "Recognition{" +
                "id=" + id +
                ", recognizerId=" + recognizerId +
                ", recognizeeId=" + recognizeeId +
                ", message='" + message + '\'' +
                ", dateOfRecognition=" + dateOfRecognition +
                ", badge=" + badge +
                '}';
    }

}
