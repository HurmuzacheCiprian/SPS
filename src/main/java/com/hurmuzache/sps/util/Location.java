package com.hurmuzache.sps.util;

import lombok.Getter;

@Getter
public enum Location {
    LONDON("London-Identifier"), LIVERPOOOL("Liverpool-Identifier"), UNKNOWN("Unknown");

    private String name;

    Location(String name) {
        this.name = name;
    }

    public static Location getLocationByIdentifier(String identifier) {
        for (Location location : Location.values()) {
            if (location.getName().equals(identifier)) {
                return location;
            }
        }
        return Location.UNKNOWN;
    }
}
