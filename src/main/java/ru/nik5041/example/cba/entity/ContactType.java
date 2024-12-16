package ru.nik5041.example.cba.entity;

import ru.nik5041.example.cba.exceptions.ValidationException;

public enum ContactType {
    PHONE,
    EMAIL;

    public static ContactType fromString(String type) {
        try {
            return ContactType.valueOf(type.toUpperCase());
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Invalid contact type: " + type);
        }
    }
}
