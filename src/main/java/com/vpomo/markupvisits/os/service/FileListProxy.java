package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Zver on 09.10.2016.
 */
public class FileListProxy {
    public FileListProxy() {

    }

    public ArrayList<ListProxy> readListProxy() {
        ArrayList<ListProxy> myListProxy = new ArrayList<>();
        try {
            File file = new File("D:/Java/WebDriver/listProxy.txt");
            //создаем объект FileReader для объекта File
            FileReader fileReader = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fileReader);
            // считаем сначала первую строку
            String line = reader.readLine();
            int i = 0;
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

}