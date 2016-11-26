package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;
import com.vpomo.markupvisits.os.service.ListFromFile;
import com.vpomo.markupvisits.os.service.WebService;

import java.util.ArrayList;

import static com.vpomo.markupvisits.os.model.Settings.PATH_LIST_PROXY;

/**
 * Created by Pomogalov on 05.10.2016.
 */
public class TestProxy {
    public static void main(String[] args) throws Exception {
        //TrackVisit trackVisit = new TrackVisit("http://evroremont.amit.ru/", "ТЦ Евроремонт", "Вентиляция", "Воздуховоды","Воздуховоды гофрированные","Воздуховоды круглые");
        TrackVisit trackVisit = new TrackVisit("http://evroremont.amit.ru/catalog/otvertki/", "ТЦ Евроремонт Отвертки", "Бокорезы", "Дрели", "Плоскогубцы", "null");

        WebService webService = new WebService();
        ListFromFile listFromFile = new ListFromFile();
        ArrayList<TrackVisit> listTrackVisit = new ArrayList<>();

        int result;
        String currentProxy = "444";
        ArrayList<ListProxy> listProxy = listFromFile.readListProxy(PATH_LIST_PROXY);

        System.out.println("trackVisit.getTitlePageBase() = " + trackVisit.getTitlePageBase());
        System.out.println("trackVisit.getClickOneURL() = " + trackVisit.getClickOneURL());
        System.out.println("trackVisit.getClickTwoURL() = " + trackVisit.getClickTwoURL());
        System.out.println("trackVisit.getClickThreeURL() = " + trackVisit.getClickThreeURL());
        System.out.println("trackVisit.getClickFourURL() = " + trackVisit.getClickFourURL());
        System.out.println("trackVisit.getBaseURL() = " + trackVisit.getBaseURL());

        listTrackVisit = listFromFile.readListTrackVisit();

        for (int i = 0; i < listTrackVisit.size(); i++) {
            System.out.println("trackVisit.getBaseURL() = " + listTrackVisit.get(i).getBaseURL());
            System.out.println("trackVisit.getTitlePageBase() = " + listTrackVisit.get(i).getTitlePageBase());
            System.out.println("trackVisit.getClickOneURL() = " + listTrackVisit.get(i).getClickOneURL());
            System.out.println("trackVisit.getClickTwoURL() = " + listTrackVisit.get(i).getClickTwoURL());
            System.out.println("trackVisit.getClickThreeURL() = " + listTrackVisit.get(i).getClickThreeURL());
            System.out.println("trackVisit.getClickFourURL() = " + listTrackVisit.get(i).getClickFourURL());

            result = webService.clickLinkURL(currentProxy, listTrackVisit.get(i));
            System.out.println("URL=" + listTrackVisit.get(i).getBaseURL() + " result=" + result);
            listFromFile.writeLog(result, currentProxy, listTrackVisit.get(i).getBaseURL());
            //listFromFile.writeLog(100, "URL=" + listTrackVisit.get(i).getBaseURL() + " result=" + result);
        }


/*        for (int i = 0; i < listProxy.size(); i++) {
            result = webService.clickLinkURL(listProxy.get(i).getAddressPort(), trackVisit);
            System.out.println("Proxy=" + listProxy.get(i).getAddressPort() + " result=" + result);
            listFromFile.writeLog(100, "Proxy=" + listProxy.get(i).getAddressPort() + " result=" + result);
        }
*/

    }
}

