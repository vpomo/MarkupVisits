package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.service.FileListProxy;
import com.vpomo.markupvisits.os.service.WebService;

/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {

    public static void main(String[] args) throws Exception {
        FileListProxy fileListProxy = new FileListProxy();
        WebService webService = new WebService();
        int result;
        String proxy1 = "5.9.117.40:3128";
        String proxy2 = "176.195.111.249:8080";
        String url1 = "https://whoer.net/ru";
        String url2 = "http://amit.ru";

        //ArrayList<ListProxy> listProxy;
        //listProxy = fileListProxy.readListProxy();
        //System.out.println(listProxy.get(0).toString());
        //System.out.println(listProxy.get(1).toString());

        result = webService.getBaseURL(proxy1, url1, "Узнать свой IP адрес");
        System.out.println("result = " + result);

        //result = clickLinkURL(proxy1, url2, "Сервисный центр", "Амурские Информационные Технологии");
        //System.out.println("result = " + result);

    }



}
