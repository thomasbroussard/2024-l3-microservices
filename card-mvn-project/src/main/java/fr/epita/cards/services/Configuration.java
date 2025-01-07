package fr.epita.cards.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Configuration {

    private Properties properties;

    private static Configuration instance;


    private Configuration(){
        this.properties = new Properties();
        try {
            String confLocation = System.getProperty("conf.location");
            if (confLocation == null){
                confLocation = "conf.properties";
            }
            this.properties.load(new FileInputStream(confLocation));
        } catch (IOException e) {
            //TODO deal with file not found, fallback?
            e.printStackTrace();
        }
    }

    public static Configuration getInstance(){
        if (instance == null){
            instance = new Configuration();
        }
        return instance;
    }


    public String get(String key){
        return this.properties.getProperty(key);
    }

    public String getOrDefault(String key, String defaultVal){
        return this.properties.getProperty(key,defaultVal);
    }







}
