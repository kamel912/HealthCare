package com.teamvii.healthcare.models;

/**
 * Created by ibrahim on 26/12/17.
 */

public class SpinnersItemArea {
    static String name;
    String id;

    public static void setName(String name) {
        SpinnersItemArea.name = name;
    }

    public static String getName(int pos) {
        return name;
    }

    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
