package com.tazuzuapp.api.activity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TestTime extends Test {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long testId;

    @NotNull
    private Long result;
}
