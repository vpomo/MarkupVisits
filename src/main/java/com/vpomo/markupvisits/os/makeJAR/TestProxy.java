package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;
import com.vpomo.markupvisits.os.service.ListFromFile;
import com.vpomo.markupvisits.os.service.WebService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Pomogalov on 05.10.2016.
 */
public class TestProxy {
    public static void main(String[] args) throws Exception {
        TrackVisit trackVisit = new TrackVisit("http://www.amur.info","ИА \"Амур.инфо\"","null","null","null","null");
        WebService webService = new WebService();
        ListFromFile listFromFile = new ListFromFile();
        String currentProxy = "";
        int result;
        ArrayList<ListProxy> listProxy = listFromFile.readListProxy();

        for (int i = 0; i < listProxy.size(); i++) {
            result = webService.clickLinkURL(listProxy.get(i).getAddressPort(), trackVisit);
            System.out.println("Proxy=" + listProxy.get(i).getAddressPort() + " result=" + result);
            listFromFile.writeLog(100, "Proxy=" + listProxy.get(i).getAddressPort() + " result=" + result);
        }
    }
}

