package util;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties getPropertyFile(String pathToConfigFile) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToConfigFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String getPropertyValue(String key) {
        String pathToConfigFile = "src/main/resources/default.properties";
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

    public String getUserLogin() {
        String url = getPropertyValue("login");
        if(url != null) return url;
        else throw new RuntimeException("Login not specified in the default.properties file.");
    }

    public String getUserPassword() {
        String url = getPropertyValue("password");
        if(url != null) return url;
        else throw new RuntimeException("Login not specified in the default.properties file.");
    }

    public String getMockedProductName() {
        String url = getPropertyValue("product376464");
        if(url != null) return url;
        else throw new RuntimeException("This product is not specified in the default.properties file.");
    }
}
