package com.tazuzu.user.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SuppressWarnings("unused")
public class Student extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long groupId;

    public Student() {}

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
