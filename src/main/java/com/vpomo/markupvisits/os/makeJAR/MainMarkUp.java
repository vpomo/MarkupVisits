package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.service.Sheduller;
import com.vpomo.markupvisits.os.service.WebService;



/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {

    public static void main(String[] args) throws Exception {
        WebService webService = new WebService();
        Sheduller sheduller = new Sheduller();

        int result;
        String currentProxy;
        String proxy1 = "5.9.117.40:3128";
        String proxy2 = "176.195.111.249:8080";
        String url1 = "https://whoer.net/ru";
        String url2 = "http://amit.ru";

        sheduller.testTimer();
        /*
        ArrayList<ListProxy> listProxy;
        listProxy = fileListProxy.readListProxy();
        //System.out.println(listProxy.get(0).toString());
        //System.out.println(listProxy.get(1).toString());

        currentProxy = listProxy.get(0).getAddressPort();

        result = webService.getBaseURL(currentProxy, url1, "Узнать свой IP адрес");
        System.out.println("result = " + result);
        fileListProxy.writeLog(result, currentProxy, url1);

        //result = clickLinkURL(proxy1, url2, "Сервисный центр", "Амурские Информационные Технологии");
        //System.out.println("result = " + result);
        */

    }



}
