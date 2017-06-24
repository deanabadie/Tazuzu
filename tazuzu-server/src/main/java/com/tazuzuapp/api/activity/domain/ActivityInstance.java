package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@SuppressWarnings("unused")
@Entity
public class ActivityInstance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private ActivityType activityType;

    @NotNull
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isMandatory;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityDate;

    @ManyToOne
    @NotNull
    private User user;

    public ActivityInstance(ActivityInstanceRequest activityInstanceRequest) {
        activityDate = activityInstanceRequest.getTime();
        isMandatory = activityInstanceRequest.isMandatory();
    }

    public ActivityInstance() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public User getUser() {
        return user;
    }

    public ActivityInstance setUser(User user) {
        this.user = user;
        return this;
    }
}
