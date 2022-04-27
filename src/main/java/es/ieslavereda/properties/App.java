package es.ieslavereda.properties;

import es.ieslavereda.properties.config.Configuration;
import es.ieslavereda.properties.config.ConfigurationXML;

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

        System.out.println(ConfigurationXML.getInstance().getDBUrl());
        System.out.println(ConfigurationXML.getInstance().getDBUser());
        System.out.println(ConfigurationXML.getInstance().getDBPassword());

        ConfigurationXML.getInstance().setDBUser("juan");
        ConfigurationXML.getInstance().setDBPassword("1111");
        ConfigurationXML.getInstance().setDBUrl("jdbc:mysql://127.0.0.1:3306/api_test");

        System.out.println(ConfigurationXML.getInstance().getDBUrl());
        System.out.println(ConfigurationXML.getInstance().getDBUser());
        System.out.println(ConfigurationXML.getInstance().getDBPassword());
    }
}
