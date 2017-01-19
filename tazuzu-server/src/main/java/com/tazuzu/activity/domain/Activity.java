package com.tazuzu.activity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by nofarb on 19-Jan-17.
 */
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long activity_id;

    @NotNull
    private String activity_name;

    private Long activity_type_id;

    private int num_of_measurements;
    @NotNull
    private Timestamp time_of_creation;
    @NotNull
    private Timestamp time_of_last_edit;
    @NotNull
    private long last_edited_by;

    public Activity(String activity_name, Long activity_type_id) {
        this.activity_name = activity_name;
        this.activity_type_id = activity_type_id;
    }
    public Activity (){}

    public Long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Long activity_id) {
        this.activity_id = activity_id;
    }

    public Long getActivity_type_id() {
        return activity_type_id;
    }

    public void setActivity_type_id(Long activity_type_id) {
        this.activity_type_id = activity_type_id;
    }

    public int getNum_of_measurements() {
        return num_of_measurements;
    }

    public void setNum_of_measurements(int num_of_measurements) {
        this.num_of_measurements = num_of_measurements;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public long getLast_edited_by() {
        return last_edited_by;
    }

    public void setLast_edited_by(long last_edited_by) {
        this.last_edited_by = last_edited_by;
    }

    public Timestamp getTime_of_creation() {
        return time_of_creation;
    }

    public void setTime_of_creation(Timestamp time_of_creation) {
        this.time_of_creation = time_of_creation;
    }

    public Timestamp getTime_of_last_edit() {
        return time_of_last_edit;
    }

    public void setTime_of_last_edit(Timestamp time_of_last_edit) {
        this.time_of_last_edit = time_of_last_edit;
    }
}
