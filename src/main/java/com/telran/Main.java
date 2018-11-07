package com.telran;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {

    private static final String PROPERTIES_FILE_NAME = "application.properties";

    @SneakyThrows
    public static void main(String[] args) {
//       try {
//           FileUtils.readFileToString(new File("file.properties"), "UTF-8");
//       } catch (Exception e) {
//           throw new RuntimeException(e);
//       }
        String fileContent = FileUtils.readFileToString(new File(PROPERTIES_FILE_NAME), "UTF-8");
        System.out.println(fileContent);

        String textToWrite = "this text I want to write to file";
        File file = new File(fileToWriteSomeText());
        FileUtils.writeStringToFile(file, textToWrite, "UTF-8");

        System.out.println(StringUtils.capitalize(textToWrite));

        String digit = StringUtils.leftPad("999", 4, "0");
        System.out.println(digit);

//        propertiesFile();
    }

    @SneakyThrows
    private static String fileToWriteSomeText() {
        Properties properties = new Properties();
//        properties.load(new FileInputStream("application.properties"));
        properties.load(Main.class
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE_NAME));


        System.out.println(properties.getProperty("application.filename"));

        return properties.getProperty("application.filename");

//        System.load("application.properties");

    }
}
