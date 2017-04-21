package com.tazuzuapp.api.activity.domain;

import com.tazuzuapp.api.general.domain.BaseEntity;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.Teacher;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "result_type")

public class Test extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long testId;

    @NotEmpty
    private Long activityId;

    @NotNull
    private Date date;

    @ManyToMany
    @JoinTable(name = "activity_students", joinColumns = {
            @JoinColumn(name = "activity_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "student_id", nullable = false, updatable = false)
    })
    private List<Student> participantsStudents;

    @ManyToMany
    @JoinTable(name = "activity_teachers", joinColumns = {
            @JoinColumn(name = "activity_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "teacher_id", nullable = false, updatable = false)
    })
    private List<Teacher> participantsTeachers;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Student> getParticipantsStudents() {
        return participantsStudents;
    }

    public void setParticipantsStudents(List<Student> participantsStudents) {
        this.participantsStudents = participantsStudents;
    }

    public List<Teacher> getParticipantsTeachers() {
        return participantsTeachers;
    }

    public void setParticipantsTeachers(List<Teacher> participantsTeachers) {
        this.participantsTeachers = participantsTeachers;
    }
}
