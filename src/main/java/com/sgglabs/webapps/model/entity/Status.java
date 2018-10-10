package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE Status (
 *     Id INT(2) NOT NULL AUTO_INCREMENT,
 *     Name VARCHAR(30) NOT NULL,
 *     CreatedBy VARCHAR(10),
 *     ModifiedBy VARCHAR(10),
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     PRIMARY KEY (Id)
 * ) ENGINE = INNODB;
 */
@Entity(name = "Status")
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CreatedBy")
    private LocalDate createdBy;

    @Column(name = "ModifiedBy")
    private LocalDate modifiedBy;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

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

    public LocalDate getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDate createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(LocalDate modifiedBy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(name, status.name) &&
                Objects.equals(createdBy, status.createdBy) &&
                Objects.equals(modifiedBy, status.modifiedBy) &&
                Objects.equals(createdDate, status.createdDate) &&
                Objects.equals(modifiedDate, status.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdBy, modifiedBy, createdDate, modifiedDate);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}