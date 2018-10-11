package com.sgglabs.webapps.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE User(
 *     Id INT(4) NOT NULL AUTO_INCREMENT,
 *     Name VARCHAR(30) NOT NULL,
 *     RoleId INT(3) NOT NULL,
 *     CreatedBy VARCHAR(10),
 *     ModifiedBy VARCHAR(10),
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     StatusId INT(2),
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (RoleId) REFERENCES Role(Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * ) ENGINE = INNODB;
 */
@Entity(name = "User")
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "RoleId")
    private String roleId;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    @Column(name = "StatusId")
    private int statusId;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
        User user = (User) o;
        return statusId == user.statusId &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(roleId, user.roleId) &&
                Objects.equals(createdBy, user.createdBy) &&
                Objects.equals(modifiedBy, user.modifiedBy) &&
                Objects.equals(createdDate, user.createdDate) &&
                Objects.equals(modifiedDate, user.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roleId, createdBy, modifiedBy, createdDate, modifiedDate, statusId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", statusId=" + statusId +
                '}';
    }
}