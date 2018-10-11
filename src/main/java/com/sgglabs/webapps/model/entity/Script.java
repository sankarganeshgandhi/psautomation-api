package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE Script (
 *     Id INT(20) NOT NULL AUTO_INCREMENT,
 *     Name VARCHAR(30) NOT NULL,
 *     Environment VARCHAR(30) NOT NULL,
 *     ScriptCommand VARCHAR(30) NOT NULL,
 *     ScriptDirPath VARCHAR(250) NOT NULL,
 *     ScriptFileName VARCHAR(100) NOT NULL,
 *     InputTemplate VARCHAR(250),
 *     CreatedBy VARCHAR(30) NOT NULL,
 *     ModifiedBy VARCHAR(30) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     StatusId INT(2) NOT NULL,
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * ) ENGINE = INNODB;
 */
@Entity(name = "Script")
@Table(name = "Script")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Environment")
    private String environment;

    @Column(name = "ScriptCommand")
    private String scriptCommand;

    @Column(name = "ScriptDirPath")
    private String scriptDirPath;

    @Column(name = "ScriptFileName")
    private String scriptFileName;

    @Column(name = "InputTemplate")
    private String inputTemplate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    @Column(name = "StatusId")
    private Integer statusId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getScriptCommand() {
        return scriptCommand;
    }

    public void setScriptCommand(String scriptCommand) {
        this.scriptCommand = scriptCommand;
    }

    public String getScriptDirPath() {
        return scriptDirPath;
    }

    public void setScriptDirPath(String scriptDirPath) {
        this.scriptDirPath = scriptDirPath;
    }

    public String getScriptFileName() {
        return scriptFileName;
    }

    public void setScriptFileName(String scriptFileName) {
        this.scriptFileName = scriptFileName;
    }

    public String getInputTemplate() {
        return inputTemplate;
    }

    public void setInputTemplate(String inputTemplate) {
        this.inputTemplate = inputTemplate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
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
        Script script = (Script) o;
        return Objects.equals(id, script.id) &&
                Objects.equals(name, script.name) &&
                Objects.equals(environment, script.environment) &&
                Objects.equals(scriptCommand, script.scriptCommand) &&
                Objects.equals(scriptDirPath, script.scriptDirPath) &&
                Objects.equals(scriptFileName, script.scriptFileName) &&
                Objects.equals(inputTemplate, script.inputTemplate) &&
                Objects.equals(createdBy, script.createdBy) &&
                Objects.equals(modifiedBy, script.modifiedBy) &&
                Objects.equals(createdDate, script.createdDate) &&
                Objects.equals(modifiedDate, script.modifiedDate) &&
                Objects.equals(statusId, script.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, environment, scriptCommand, scriptDirPath, scriptFileName,
                inputTemplate, createdBy, modifiedBy, createdDate, modifiedDate, statusId);
    }

    @Override
    public String toString() {
        return "Script{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", environment='" + environment + '\'' +
                ", scriptCommand='" + scriptCommand + '\'' +
                ", scriptDirPath='" + scriptDirPath + '\'' +
                ", scriptFileName='" + scriptFileName + '\'' +
                ", inputTemplate='" + inputTemplate + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", statusId=" + statusId +
                '}';
    }
}