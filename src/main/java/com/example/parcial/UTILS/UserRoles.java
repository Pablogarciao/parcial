package com.example.parcial.UTILS;

import java.util.List;

public class UserRoles {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String ATTENDEE = "ATTENDEE";
    public static final String ORGANIZER = "ORGANIZER";

    public static List<String> getAllRoles() {
        return List.of(ADMIN, USER, ATTENDEE, ORGANIZER);
    }
}
