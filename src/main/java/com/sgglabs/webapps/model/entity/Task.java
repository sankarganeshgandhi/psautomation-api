package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE Task (
 *     Id BIGINT(20) NOT NULL AUTO_INCREMENT,
 *     Description VARCHAR(100) NOT NULL,
 *     Remarks VARCHAR(250) NULL,
 *     ScriptId INT(20) NOT NULL,
 *     InputValues VARCHAR(250) NULL,
 *     CreatedBy INT(4) NOT NULL,
 *     ModifiedBy INT(4) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     StatusId INT(2) NOT NULL,
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (ScriptId) REFERENCES Script(Id),
 *     FOREIGN KEY (CreatedBy) REFERENCES User(Id),
 *     FOREIGN KEY (ModifiedBy) REFERENCES User(Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * ) ENGINE = INNODB;
 */
@Entity(name = "Task")
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Description")
    private String description;

    @Column(name = "Remarks")
    private String remarks;

    @Column(name = "ScriptId")
    private Integer scriptId;

    @Column(name = "InputValues")
    private String inputValues;

    @Column(name = "CreatedBy")
    private int createdBy;

    @Column(name = "ModifiedBy")
    private int modifiedBy;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    @Column(name = "StatusId")
    private Integer statusId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getScriptId() {
        return scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public String getInputValues() {
        return inputValues;
    }

    public void setInputValues(String inputValues) {
        this.inputValues = inputValues;
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return createdBy == task.createdBy &&
                modifiedBy == task.modifiedBy &&
                Objects.equals(id, task.id) &&
                Objects.equals(description, task.description) &&
                Objects.equals(remarks, task.remarks) &&
                Objects.equals(scriptId, task.scriptId) &&
                Objects.equals(inputValues, task.inputValues) &&
                Objects.equals(createdDate, task.createdDate) &&
                Objects.equals(modifiedDate, task.modifiedDate) &&
                Objects.equals(statusId, task.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, remarks, scriptId, inputValues, createdBy, modifiedBy,
                createdDate, modifiedDate, statusId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", remarks='" + remarks + '\'' +
                ", scriptId=" + scriptId +
                ", inputValues='" + inputValues + '\'' +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", statusId=" + statusId +
                '}';
    }
}