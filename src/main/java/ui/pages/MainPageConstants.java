package ui.pages;

import java.io.IOException;
import java.util.Properties;

public class MainPageConstants {

    private static final String PAGE_PROP_PATH = "config.properties";
    private static final Properties pageProp = initPageProperties();

    public static final String LOGIN_SUCCESSFUL = pageProp.getProperty("login.successful");


    private MainPageConstants(){
    }
    private static Properties initPageProperties(){
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(PAGE_PROP_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + PAGE_PROP_PATH);
        }
        return properties;
    }
}
