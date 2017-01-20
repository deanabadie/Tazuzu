package com.tazuzu.activity.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@SuppressWarnings("unused")
public class Activity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activityId;

    @NotNull
    private String activityName;

    private Long ActivityTypeId;

    private int NumOfMeasurements;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date TimeOfCreation;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date TimeOfLastEdit;

    @NotNull
    private long LastEditedBy;

    public Activity (){}

}
