package util;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
//    private Properties properties;
//    private final String propertyFilePath= "/src/main/resources/default.properties";

//    private static String pathToAndroidConfigFile = "configsAndroid.properties";
    private static String pathToConfigFile = "src/main/resources/default.properties";



//    public static String getAndroidProperty (String key){
//        return getPropertyFile(pathToAndroidConfigFile).getProperty(key);
//    }

    private static Properties getPropertyFile(String pathToConfigFile) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToConfigFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static String getPropertyValue(String key) {
        return getPropertyFile(pathToConfigFile).getProperty(key);
    }

    public long getImplicitlyWait() {
        String implicitlyWait = getPropertyValue("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the default.properties file.");
    }

    public String getApplicationUrl() {
        String url = getPropertyValue("base_URL");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the default.properties file.");
    }
}
