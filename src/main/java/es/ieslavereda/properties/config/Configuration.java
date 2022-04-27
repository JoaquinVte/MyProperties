package es.ieslavereda.properties.config;

import java.io.*;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;

    private static Properties myProperties;
    private final String DEFAULT_PROPERTIES_FILE = "default.properties";
    private final String CUSTOM_PROPERTIES_FILE = "custom.properties";

    private Configuration(){

        Properties defaultProperties = new Properties();

        try(FileInputStream fis = new FileInputStream(DEFAULT_PROPERTIES_FILE)){

            defaultProperties.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        myProperties = new Properties(defaultProperties);

        try(FileInputStream fis = new FileInputStream(CUSTOM_PROPERTIES_FILE)){

            myProperties.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Configuration getInstance(){
        if(instance==null)
            instance = new Configuration();
        return instance;
    }

    private void save(){
        try (FileOutputStream fos = new FileOutputStream(CUSTOM_PROPERTIES_FILE)) {
            myProperties.store(fos, "UTF-8");
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
