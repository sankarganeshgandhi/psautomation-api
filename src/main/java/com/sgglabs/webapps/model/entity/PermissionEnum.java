package com.sgglabs.webapps.model.entity;

public enum PermissionEnum {
    Create(1),
    Update(2),
    Delete(3),
    Approve(4),
    Run(5);

    private int enumValue;
    private String[] enumValues = new String[] {
        "Create",
        "Update",
        "Delete",
        "Approve",
        "Run",
    };

    PermissionEnum(int value) {
        this.enumValue = value;
    }

    public int getValue() {
        return this.enumValue;
    }

    public String getString() {
        String status = null;
        return enumValues[enumValue - 1];
    }
}