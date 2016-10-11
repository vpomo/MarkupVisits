package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Zver on 11.10.2016.
 */
public class ShedulledTask extends TimerTask {
    FileListProxy fileListProxy = new FileListProxy();
    WebService webService = new WebService();
    Sheduller sheduller = new Sheduller();

    int result;
    String currentProxy;
    String proxy1 = "5.9.117.40:3128";
    String proxy2 = "176.195.111.249:8080";
    String url1 = "https://whoer.net/ru";
    String url2 = "http://amit.ru";

    @Override
    public void run() {
        System.out.println("TimerTask начал свое выполнение в:" + new Date());
        completeTask();
        System.out.println("TimerTask закончил свое выполнение в:" + new Date());
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 2 секунды
            ArrayList<ListProxy> listProxy;
            listProxy = fileListProxy.readListProxy();
            System.out.println(listProxy.get(0).toString());
            System.out.println(listProxy.get(1).toString());

            currentProxy = listProxy.get(0).getAddressPort();

            result = webService.getBaseURL(currentProxy, url1, "Узнать свой IP адрес");
            System.out.println("result = " + result);
            fileListProxy.writeLog(result, currentProxy, url1);

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
