package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/*
CREATE TABLE Task (
    Id BIGINT(20) NOT NULL AUTO_INCREMENT,
    Name VARCHAR(30) NOT NULL,
    CreatedBy INT(4) NOT NULL,
    ModifiedBy INT(4) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    StatusId INT(2) NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (CreatedBy) REFERENCES UserRepository(Id),
    FOREIGN KEY (ModifiedBy) REFERENCES UserRepository(Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;
 */
@Entity(name = "Task")
@Table(name = "Task")
public class Task {
    private static final String TO_STRING_FORMAT =
            "TaskRepository[id=%s, name='%s', createdBy='%s', modifiedBy='%s', createdDate='%s'" +
                    "modifiedDate=%s, statusId=%s]";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CreatedBy")
    private int createdBy;

    @Column(name = "ModifiedBy")
    private int modifiedBy;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    @Column(name = "StatusId")
    private int statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return createdBy == task.createdBy &&
                modifiedBy == task.modifiedBy &&
                statusId == task.statusId &&
                Objects.equals(id, task.id) &&
                Objects.equals(name, task.name) &&
                Objects.equals(createdDate, task.createdDate) &&
                Objects.equals(modifiedDate, task.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdBy, modifiedBy, createdDate, modifiedDate, statusId);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, id, name, createdBy, modifiedBy, createdDate, modifiedDate,
                statusId);
    }
}