package com.vpomo.markupvisits.os.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.vpomo.markupvisits.os.model.Settings.NUMBER_DAYS_RUNNING;
import static com.vpomo.markupvisits.os.model.Settings.TIME_FIRST_START;
import static java.lang.Thread.sleep;

/**
 * Created by Pomogalov on 11.10.2016.
 */
public class Sheduller {
    public void runTimer() throws ParseException, InterruptedException {
        TimerTask timerTask = new ShedulledTask();
        ListFromFile listFromFile = new ListFromFile();
        // стартуем TimerTask в виде демона

        Timer timer = new Timer(true);
        String startTimer = TIME_FIRST_START;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd'--'HH:mm:ss");
        Date startDate= dateFormat.parse(startTimer);
        listFromFile.writeLog(100, "Программа стартовала в: " + new Date());
        System.out.println("Программа стартовала в: " + new Date());
        listFromFile.writeLog(100, "Накрутка счетчика начнется в: " + startDate);
        sleep(2000);
        // будем запускать каждый день ( 24 часа * 60 мин * 60 сек * 1000 миллисекунд)
        timer.scheduleAtFixedRate(timerTask, startDate, 24 * 60 * 60 * 1000);

        try {
            sleep(NUMBER_DAYS_RUNNING * 24 * 60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        try {
            listFromFile.writeLog(100, "Программа закончила работу: " + new Date());
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
