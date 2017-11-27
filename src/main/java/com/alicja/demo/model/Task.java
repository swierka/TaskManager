package com.alicja.demo.model;

import org.jboss.logging.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable=false)
    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate executionDate;

    @Column(nullable=false)
    private Boolean isFinished;

    private double timeSpent;

    public Task() {
    }

    public Task(String name, String description, LocalDate deadline, LocalDate executionDate, Boolean isFinished, double timeSpent) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.executionDate = executionDate;
        this.isFinished = isFinished;
        this.timeSpent = timeSpent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isFinished=" + isFinished +
                ", timeSpent=" + timeSpent +
                '}';
    }
}
