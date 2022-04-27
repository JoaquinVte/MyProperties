package es.ieslavereda.properties.config;

import java.io.*;
import java.util.Properties;

public class ConfigurationXML {

    private static ConfigurationXML instance;

    private static Properties myProperties;
    private final String DEFAULT_PROPERTIES_FILE = "defaultXML.properties";
    private final String CUSTOM_PROPERTIES_FILE = "customXML.properties";

    private ConfigurationXML(){

        Properties defaultProperties = new Properties();

        try(FileInputStream fis = new FileInputStream(DEFAULT_PROPERTIES_FILE)){

            defaultProperties.loadFromXML(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        myProperties = new Properties(defaultProperties);

        try(FileInputStream fis = new FileInputStream(CUSTOM_PROPERTIES_FILE)){

            myProperties.loadFromXML(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConfigurationXML getInstance(){
        if(instance==null)
            instance = new ConfigurationXML();
        return instance;
    }

    private void save(){
        try (FileOutputStream fos = new FileOutputStream(CUSTOM_PROPERTIES_FILE)) {
            myProperties.storeToXML(fos,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDBUrl(){
        return myProperties.getProperty("MYSQL_DB_URL");
    }
    public void setDBUrl(String dbUrl){
        myProperties.setProperty("MYSQL_DB_URL",dbUrl);
        save();
    }
    public String getDBUser(){
        return myProperties.getProperty("MYSQL_DB_USERNAME");
    }
    public void setDBUser(String dbUser){
        myProperties.setProperty("MYSQL_DB_USERNAME",dbUser);
        save();
    }
    public String getDBPassword(){
        return myProperties.getProperty("MYSQL_DB_PASSWORD");
    }
    public void setDBPassword(String dbPassword){
        myProperties.setProperty("MYSQL_DB_PASSWORD",dbPassword);
        save();
    }
}