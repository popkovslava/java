package org.project.dao;

public class DaoStart {
    private static final DaoStart INSTANCE = new DaoStart();

    public String getDaoStartName() {
        return "User";
    }

    public String getDaoStartMassage() {
        return "Hello Word";
    }

    public static DaoStart getInstance() {
        return INSTANCE;
    }
}
