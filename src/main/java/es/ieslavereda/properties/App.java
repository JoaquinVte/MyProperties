package es.ieslavereda.properties;

import es.ieslavereda.properties.config.Configuration;

public class App {
    public static void main(String[] args) {

        System.out.println(Configuration.getInstance().getDBUrl());
        System.out.println(Configuration.getInstance().getDBUser());
        System.out.println(Configuration.getInstance().getDBPassword());

        Configuration.getInstance().setDBUser("juan");
        Configuration.getInstance().setDBPassword("1111");
        Configuration.getInstance().setDBUrl("jdbc:mysql://127.0.0.1:3306/api_test");

        System.out.println(Configuration.getInstance().getDBUrl());
        System.out.println(Configuration.getInstance().getDBUser());
        System.out.println(Configuration.getInstance().getDBPassword());
    }
}
