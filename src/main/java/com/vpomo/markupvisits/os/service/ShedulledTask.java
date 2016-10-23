package com.vpomo.markupvisits.os.service;

import com.vpomo.markupvisits.os.model.ListProxy;
import com.vpomo.markupvisits.os.model.TrackVisit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;

import static com.vpomo.markupvisits.os.model.InputData.PATH_LIST_DIRTY_PROXY;
import static com.vpomo.markupvisits.os.model.InputData.PATH_LIST_PROXY;

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
        this.listTrackVisit = listFromFile.readListTrackVisit();
    }

    @Override
    public void run() {
        System.out.println("Начат очередной обход сайтов из списка в: " + new Date());
        this.listFromFile.writeLog(100, "Начат очередной обход сайтов из списка в: " + new Date());
        //this.listFromFile.writeLog(100, "Начата проверка рабочих прокси-серверов из списка в: " + new Date());
        //makeListWorkingProxy();
        //this.listFromFile.writeLog(100, "Закончена проверка рабочих прокси-серверов из списка в: " + new Date());
        completeTask();
        System.out.println("Очередной обход сайтов из списка закончен в: " + new Date());
        this.listFromFile.writeLog(100, "Очередной обход сайтов из списка закончен в: " + new Date());
    }

    private void makeListWorkingProxy() throws InterruptedException {
        TrackVisit trackVisitForTest = new TrackVisit("http://www.amur.info", "ИА \"Амур.инфо\"", "null", "null", "null", "null");
        listProxy.clear();
        listProxy.trimToSize();
        listProxy = listFromFile.readListProxy(PATH_LIST_DIRTY_PROXY);
        ArrayList<ListProxy> listGoodProxy = new ArrayList<>();
        int result;
        Boolean isContainsProxy;

        int numberProxy = listProxy.size();
        System.out.println("numberProxy = " + numberProxy);

        if (listFromFile.deleteFile(PATH_LIST_PROXY) == 1) {
            System.out.println("File deleted ..................................................");
        }

        if (numberProxy > 0) {
            for (int i = 0; i < numberProxy; i++) {
                isContainsProxy = false;
                result = webService.getBaseURL(listProxy.get(i).getAddressPort(), trackVisitForTest);
                listFromFile.writeLog(100, listProxy.get(i).getAddressPort() + " - " + result);
                if (result == 1) {
                    if (listGoodProxy.isEmpty()) {
                        listGoodProxy.add(new ListProxy(true, listProxy.get(i).getAddressPort()));
                    } else {
                        for (int j = 0; j < listGoodProxy.size(); j++) {
                            if (listProxy.get(i).getAddressPort().equals(listGoodProxy.get(j).getAddressPort())) {
                                isContainsProxy = true;
                                j = listGoodProxy.size();
                            }
                        }
                        if (!isContainsProxy) {
                            listGoodProxy.add(new ListProxy(true, listProxy.get(i).getAddressPort()));
                        }
                    }
                }
            }
            for (int i = 0; i < listGoodProxy.size(); i++) {
                listFromFile.writeStringToFile(PATH_LIST_PROXY, listGoodProxy.get(i).getAddressPort());
            }
        }
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
        listProxy = listFromFile.readListProxy(PATH_LIST_PROXY);
        numberProxy = listProxy.size();

        numberVisit = listTrackVisit.size();
        timeDelay = (int) Math.floor(21600000 / (numberVisit + 3));
        //timeDelay = 1000;
        listFromFile.writeLog(100, "Число ссылок на трэккинг = " + numberVisit + "; Число прокси-серверов в списке = " + numberProxy + ";");

        try {
            j = -1;
            if (numberVisit > 0) {
                if (numberProxy > 0) {
                    for (i = 0; i < numberVisit; i++) {
                        if (j == (numberProxy - 1)) {
                            j = 0;
                        } else {
                            j = j + 1;
                        }


                        System.out.println("i=" + i + " j=" + j);
                        currentProxy = listProxy.get(j).getAddressPort();
                        currentTrackVisit = listTrackVisit.get(i);
                        result = webService.clickLinkURL(currentProxy, currentTrackVisit);
                        System.out.println("result = " + result);
                        listFromFile.writeLog(result, currentProxy, currentTrackVisit.getBaseURL());

                        if ((result == 2) || (result == 3)) {
                            i--;
                            listProxy.get(j).setAvailability(false);
                        } else {
                            System.out.println("Задержка ...");
                            koefTimeWaiting = timeWaiting.nextInt(20);
                            Thread.sleep(12000 * koefTimeWaiting + timeDelay);
                        }
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
