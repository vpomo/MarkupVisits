package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.vpomo.markupvisits.os.model.Settings.*;

/**
 * Created by Zver on 09.10.2016.
 */
public class ListFromFile {

    public void writeLog(int result, String proxy, String url) {
        String writedString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");

        switch (result) {
            case 1:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "OK!";
                break;
            case 2:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - The page wasn't loaded";
                break;
            case 3:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Base Page Exception";
                break;
            case 40:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 1 (No such element Exception)";
                break;
            case 41:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 1 (WebDriver Exception)";
                break;
            case 50:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 2 (No such element Exception)";
                break;
            case 51:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 2 (WebDriver Exception)";
                break;
            case 60:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 3 (No such element Exception)";
                break;
            case 61:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 3 (WebDriver Exception)";
                break;
            case 70:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 4 (No such element Exception)";
                break;
            case 71:
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Page 4 (WebDriver Exception)";
                break;
            default:
                break;
        }
        writeStringToFile(PATH_LOGS, writedString);
    }

    public void writeLog(int result, String message) {
        String writedString = "";
        switch (result) {
            case 100:
                writedString = message;
                break;
            default:
                break;
        }
        writeStringToFile(PATH_LOGS, writedString);
    }

    public ArrayList<ListProxy> readListProxy(String pathToFile) {
        ArrayList<ListProxy> myListProxy = new ArrayList<>();
        try {
            File file = new File(pathToFile);
            //создаем объект FileReader для объекта File
            FileReader fileReader = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fileReader);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                myListProxy.add(new ListProxy(true, line));
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myListProxy;
    }

    public ArrayList<TrackVisit> readListTrackVisit() {
        ArrayList<TrackVisit> listTrackVisit = new ArrayList<>();
        TrackVisit trackVisit = null;
        Scanner scanner = null;
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(PATH_TRACK_VISIT), "UTF-8"));
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                scanner = new Scanner(line);
                trackVisit = new TrackVisit();
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (i == 0) {
                        trackVisit.setBaseURL(data);
                    } else if (i == 1) {
                        trackVisit.setTitlePageBase(data);
                    } else if (i == 2) {
                        trackVisit.setClickOneURL(data);
                    } else if (i == 3) {
                        trackVisit.setClickTwoURL(data);
                    } else if (i == 4) {
                        trackVisit.setClickThreeURL(data);
                    } else if (i == 5) {
                        trackVisit.setClickFourURL(data);
                    } else {
                        writeLog(100, "Некорректные данные для трэккинга");
                    }
                    i = i + 1;
                }
                i = 0;
                listTrackVisit.add(trackVisit);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listTrackVisit;
    }


    public void writeStringToFile(String pathToFile, String writingString) {
        File file = new File(pathToFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String dataWithNewLine = writingString + System.getProperty("line.separator");
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(dataWithNewLine);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int deleteFile(String pathToFile) {
        File file = new File(pathToFile);
        if (file.exists()) {
            file.delete();
            return 1;
        }
        return 0;
    }

}
