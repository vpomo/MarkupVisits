package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.vpomo.markupvisits.os.model.InputData.PATH_LIST_PROXY;
import static com.vpomo.markupvisits.os.model.InputData.PATH_LOGS;
import static com.vpomo.markupvisits.os.model.InputData.PATH_TRACK_VISIT;

/**
 * Created by Zver on 09.10.2016.
 */
public class ListFromFile {

    public void writeLog(int result, String proxy, String url){
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
                writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ") - Exception";
                break;
            default:
                break;
        }
        writeStringToFile(PATH_LOGS, writedString);
    }

    public void writeLog(int result, String message){
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

    public ArrayList<ListProxy> readListProxy() {
        ArrayList<ListProxy> myListProxy = new ArrayList<>();
        try {
            File file = new File(PATH_LIST_PROXY);
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
            File file = new File(PATH_TRACK_VISIT);
            //создаем объект FileReader для объекта File
            FileReader fileReader = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fileReader);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                scanner = new Scanner(line);
                trackVisit = new TrackVisit();
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (i==0) {
                        trackVisit.setBaseURL(data);
                    } else if (i==1){
                        trackVisit.setTitlePageBase(data);
                    } else if(i==2) {
                        trackVisit.setClickOneURL(data);
                    } else if(i==3) {
                        trackVisit.setClickTwoURL(data);
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
            fileReader.close();
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
        try{
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(dataWithNewLine);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
