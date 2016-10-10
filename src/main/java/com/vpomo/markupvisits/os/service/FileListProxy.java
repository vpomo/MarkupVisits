package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zver on 09.10.2016.
 */
public class FileListProxy {
public static final String pathListProxy = "D:/Java/WebDriver/Proxy/listProxy.txt";
public static final String pathBadProxy = "D:/Java/WebDriver/Proxy/badProxy.txt";
public static final String pathLogs = "D:/Java/WebDriver/Logs/log.txt";


    public void writeLog(int result, String proxy, String url){
        String writedString;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");

        if (result == 1) {
            writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "OK!";
        } else {
            writedString = dateFormat.format(new Date()) + " - " + proxy + " - " + url + " - " + "Error" + "(" + result + ")";
        }
        writeStringToFile(pathLogs, writedString);
    }

    public ArrayList<ListProxy> readListProxy() {
        ArrayList<ListProxy> myListProxy = new ArrayList<>();
        try {
            File file = new File(pathListProxy);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myListProxy;
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
