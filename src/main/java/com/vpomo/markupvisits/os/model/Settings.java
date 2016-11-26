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
    public static int NUMBER_DAYS_RUNNING = 1;

    public static String PATH_CHROME_DRIVER;

    public static String PATH_LIST_PROXY;
    public static String PATH_LIST_DIRTY_PROXY;
    public static String PATH_BAD_PROXY = "./setupJAR/Proxy/badProxy.txt";
    public static String PATH_LOGS;
    public static String PATH_TRACK_VISIT;

    public static String readConfig() {
        Properties prop = new Properties();
        InputStream propStream = null;
        String result = "";
        try {
            propStream = new FileInputStream(PATH_TO_CONFIG);
            if (propStream == null) {
                System.out.println("Not reading config");
            }
            if (propStream != null) {
                prop.load(propStream);
                // read configuration

                String timeFirstStart = prop.getProperty("TIME_FIRST_START");
                if (!timeFirstStart.equals("")) {
                    TIME_FIRST_START = timeFirstStart;
                } else {
                    result = "Не указана дата и время запуска. Пример: 2016/11/18--07:01:00" + "\n";
                }

                String numberDays = prop.getProperty("NUMBER_DAYS_RUNNING");
                if (!numberDays.equals("")) {
                    NUMBER_DAYS_RUNNING = Integer.parseInt(numberDays);
                } else {
                    result = result + "Не указанo сколько дней будет работать программа. Пример: 30" + "\n";
                }

                String pathChromeDriver = prop.getProperty("PATH_CHROME_DRIVER");
                if (!pathChromeDriver.equals("")) {
                    PATH_CHROME_DRIVER = pathChromeDriver;
                } else {
                    result = result + "Не указан путь к драйверу Chrome. Пример: ./setup/chromedriver.exe" + "\n";
                }

                String pathListProxy = prop.getProperty("PATH_LIST_PROXY");
                if (!pathListProxy.equals("")) {
                    PATH_LIST_PROXY = pathListProxy;
                } else {
                    result = result + "Не указан путь к обработанному proxy-списку. Пример: ./setup/Proxy/listProxy.txt" + "\n";
                }

                String pathListDirtyProxy = prop.getProperty("PATH_LIST_DIRTY_PROXY");
                if (!pathListDirtyProxy.equals("")) {
                    PATH_LIST_DIRTY_PROXY = pathListDirtyProxy;
                } else {
                    result = result + "Не указан путь к исходному proxy-списку. Пример: ./setup/Proxy/listDirtyProxy.txt" + "\n";
                }

                String pathLogs = prop.getProperty("PATH_LOGS");
                if (!pathLogs.equals("")) {
                    PATH_LOGS = pathLogs;
                } else {
                    result = result + "Не указан путь к исходному proxy-списку. Пример: ./setup/Logs/log.txt" + "\n";
                }

                String pathTrackVisit = prop.getProperty("PATH_TRACK_VISIT");
                if (!pathTrackVisit.equals("")) {
                    PATH_TRACK_VISIT = pathTrackVisit;
                } else {
                    result = result + "Не указан путь к исходному proxy-списку. Пример: ./setup/Init/track.txt" + "\n";
                }
                System.out.println(PATH_CHROME_DRIVER);
            }

        } catch (Exception ex) {
            System.out.println("Couldn't read config properties");
            result = result + "В конфигурационном файле введены не все первоначальные значения ...";
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
