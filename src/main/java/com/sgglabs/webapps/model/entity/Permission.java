package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * CREATE TABLE Permission (
 *     Id INT(3) NOT NULL AUTO_INCREMENT,
 *     Name VARCHAR(30) NOT NULL,
 *     CreatedBy VARCHAR(10),
 *     ModifiedBy VARCHAR(10),
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     StatusId INT(2),
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * ) ENGINE = INNODB;
 */
@Entity(name = "Permission")
@Table(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

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
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(modifiedBy, that.modifiedBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedDate, that.modifiedDate) &&
                Objects.equals(statusId, that.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdBy, modifiedBy, createdDate, modifiedDate, statusId);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", statusId=" + statusId +
                '}';
    }
}