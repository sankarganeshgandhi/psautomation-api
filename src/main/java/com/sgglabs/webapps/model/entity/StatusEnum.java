package com.sgglabs.webapps.model.entity;

/**
 *
 */
public enum StatusEnum {
    Inactive(1),
    Active(2),
    Submitted(3),   // HTTP - POST (Create)
    Approved(4),    // HTTP - PUT approve
    Rejected(5),    // HTTP - PUT reject
    Completed(6),   // Run
    Expired(7);     // Expired by system job

    private int enumValue;
    private String[] enumValues = new String[] {
        "Inactive",
        "Active",
        "Submitted",
        "Approved",
        "Rejected",
        "Completed",
        "Expired"
    };

    StatusEnum(int value) {
        this.enumValue = value;
    }

    public int getValue() {
        return this.enumValue;
    }

    public String getString() {
        String status = null;
        return enumValues[enumValue - 1];
        /*
        if (enumValue == 1) {
            status = "Inactive";
        } else if (enumValue == 2) {
            status = "Active";
        }
        return status;
        */
    }
}