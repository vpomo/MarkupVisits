package com.vpomo.markupvisits.os.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Pomogalov on 11.10.2016.
 */
public class Sheduller extends TimerTask {
    public void testTimer() throws ParseException {
        TimerTask timerTask = new Sheduller();
        // стартуем TimerTask в виде демона

        Timer timer = new Timer(true);
        String startTimer = "2016/10/11--19:09:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd'--'HH:mm:ss");
        Date startDate= dateFormat.parse(startTimer);
        System.out.println("Программа стартовала в: " + new Date());
        System.out.println("Требуемый функционал будет запущен в: " + startDate);

        // будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
        timer.scheduleAtFixedRate(timerTask, startDate, 1 * 1000);

        System.out.println("TimerTask начал выполнение");

        // вызываем cancel() через какое-то время
        try {
            System.out.println("TimerTask ожидает 40 000 мс");
            Thread.sleep(40000);
            System.out.println("TimerTask закончил ожидание в 40 000 мс");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask прекращен");
        try {
            System.out.println("TimerTask ожидает 3 000 мс");
            Thread.sleep(3000);
            System.out.println("TimerTask закончил ожидание в 3 000 мс");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("TimerTask начал свое выполнение в:" + new Date());
        completeTask();
        System.out.println("TimerTask закончил свое выполнение в:" + new Date());
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
