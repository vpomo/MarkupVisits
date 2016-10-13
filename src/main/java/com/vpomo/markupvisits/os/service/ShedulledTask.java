package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by Zver on 11.10.2016.
 */
public class ShedulledTask extends TimerTask {
    private ListFromFile listFromFile;
    private WebService webService;
    private ArrayList<ListProxy> listProxy;
    private ArrayList<TrackVisit> listTrackVisit;

    public ShedulledTask() {
        this.listFromFile = new ListFromFile();
        this.listTrackVisit = new ArrayList<>();
        this.webService = new WebService();

        this.listProxy = listFromFile.readListProxy();
        this.listTrackVisit = listFromFile.readListTrackVisit();
    }

    @Override
    public void run() {
        System.out.println("Начат очередной обход сайтов из списка в: " + new Date());
        this.listFromFile.writeLog(100, "Начат очередной обход сайтов из списка в: " + new Date());
        completeTask();
        System.out.println("Очередной обход сайтов из списка закончен в: " + new Date());
        this.listFromFile.writeLog(100, "Очередной обход сайтов из списка закончен в: " + new Date());
    }

    private void completeTask() {
        String currentProxy;
        TrackVisit currentTrackVisit;
        Random timeWaiting = new Random();
        int koefTimeWaiting;

        int result, i, j;
        int timeDelay;
        int numberProxy = 0;
        int numberVisit = 0;

        // выполнение займет 12 часов или 43 200 000 секунд
        // выполнение займет 6 часов или 21 600 000 секунд
        // вычисляем среднее время задержки между обращениями к сайту
        numberProxy = listProxy.size();
        numberVisit = listTrackVisit.size();
        timeDelay = (int) Math.floor(21600000 / (numberVisit + 3));
        listFromFile.writeLog(100, "Число ссылок на трэккинг = " + numberVisit + "; Число прокси-серверов в списке = " + numberProxy + ";");

        try {
            j = 0;
            if (numberVisit > 0) {
                if (numberProxy > 0) {
                    for (i = 0; i < numberVisit; i++) {
                        if (numberProxy > i) {
                            j = i;
                        } else {
                            if (numberProxy == i) {
                                j = 0;
                            } else {
                                if (j == numberProxy) {
                                    j = 0;
                                } else {
                                    j = j + 1;
                                }
                            }
                        }
                        System.out.println("i=" + i + " j=" + j);
                        currentProxy = listProxy.get(j).getAddressPort();
                        currentTrackVisit = listTrackVisit.get(i);

                        result = webService.clickLinkURL(currentProxy, currentTrackVisit);
                        System.out.println("result = " + result);
                        listFromFile.writeLog(result, currentProxy, currentTrackVisit.getBaseURL());

                        koefTimeWaiting = timeWaiting.nextInt(20);
                        Thread.sleep(12000 * koefTimeWaiting + timeDelay);
                    }
                } else {
                    listFromFile.writeLog(100, "Ошибка! Не сформирован файл со списком прокси-серверов ...");
                }
            } else {
                listFromFile.writeLog(100, "Ошибка! Не сформирован файл трэккинга сайта ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
