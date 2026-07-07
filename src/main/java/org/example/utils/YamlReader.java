package org.example.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Properties;
//credentials.manager.username
public class YamlReader {

    public static String yamlFilePath = "";
    public  static Properties properties;
    public static String setYamlFilePath() throws IOException {
        properties = new Properties();
        InputStream propStream = new FileInputStream("src"+ File.separator+"test"+File.separator+"java"+File.separator+"resources"+File.separator+"configuration"+File.separator+"config.properties");
        try {
            properties.load(propStream);
            } catch (IOException e) {
                throw new IOException("Could not find config.properties in classpath or " + propStream);
            }

        String environment = System.getProperty("Environment") != null ? System.getProperty("Environment") : properties.getProperty("Environment");
        if (environment.equalsIgnoreCase("staging") || environment.equalsIgnoreCase("Stage")) {
            yamlFilePath = "src/test/java/resources/testdata/stagedata.yaml";
        }
        return yamlFilePath;
    }

    public static String getData(String token) throws IOException {
        setYamlFilePath();
        Yaml yaml = new Yaml();
        Map<String, Object> object = yaml.load(new FileInputStream(yamlFilePath));
        return getValues(object, token);
    }

    public static String getDataFromYaml(String token) throws IOException {
        return getData(token);
    }

    public static String getValues(Map<String, Object> map, String token) {
        if (token.contains(".")) {
            String[] keys = token.split("\\.");
            // [value1,value2,value3]
            map = (Map<String, Object>) map.get(keys[0]);
            token = token.replaceAll(keys[0] + ".", "");
            return getValues((Map<String, Object>) map, token);
        }
        return (String) map.get(token);
    }

}
