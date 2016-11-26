package com.vpomo.markupvisits.os.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Zver on 11.10.2016.
 */
public class Settings {
    /*
    public static final String TIME_FIRST_START = "2016/10/18--07:01:00";
    public static final int NUMBER_DAYS_RUNNING = 3;

    public static final String PATH_CHROME_DRIVER = "D:/Java/WebDriver/chromedriver.exe";

    public static final String PATH_LIST_PROXY = "D:/Java/WebDriver/Proxy/listProxy.txt";
    public static final String PATH_LIST_DIRTY_PROXY = "D:/Java/WebDriver/Proxy/listDirtyProxy.txt";
    public static final String PATH_BAD_PROXY = "D:/Java/WebDriver/Proxy/badProxy.txt";
    public static final String PATH_LOGS = "D:/Java/WebDriver/Logs/log.txt";
    public static final String PATH_TRACK_VISIT = "D:/Java/WebDriver/Init/track.txt";
*/
    public static String PATH_TO_CONFIG = "./setupJAR/Init/config.txt";

    public static String TIME_FIRST_START;
    public static int NUMBER_DAYS_RUNNING = 365;

    public static String PATH_CHROME_DRIVER = "./setupJAR/chromedriver.exe";

    public static String PATH_LIST_PROXY = "./setupJAR/Proxy/listProxy.txt";
    public static String PATH_LIST_DIRTY_PROXY = "./setupJAR/Proxy/listDirtyProxy.txt";
    public static String PATH_BAD_PROXY = "./setupJAR/Proxy/badProxy.txt";
    public static String PATH_LOGS = "./setupJAR/Logs/log.txt";
    public static String PATH_TRACK_VISIT = "./setupJAR/Init/track.txt";

    public String readConfig() {
        Properties prop = new Properties();
        InputStream propStream = null;
        String result;
        try {
            propStream = new FileInputStream("./setupJAR/Init/config.txt");
            if (propStream == null) {
                System.out.println("Not reading config");
            }
            if (propStream != null) {
                prop.load(propStream);
                // read configuration
                String numberDays = prop.getProperty("NUMBER_DAYS_RUNNING");
                String timeFirstStart = prop.getProperty("TIME_FIRST_START");
                if (timeFirstStart != null) {
                    TIME_FIRST_START = timeFirstStart;
                } else { result = "Не указана дата и время запуска. Пример: 2016/11/18--07:01:00"}


                System.out.println("timeFirstStart = " + TIME_FIRST_START);
            }
        } catch (Exception ex) {
            System.out.println("Couldn't read config.properties");
        } finally {
            if (propStream != null) {
                try {
                    propStream.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close input stream: " + e.getMessage());
                }
            }
        }
        return result;
    }



}
