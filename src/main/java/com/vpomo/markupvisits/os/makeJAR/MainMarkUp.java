package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.model.Settings;
import com.vpomo.markupvisits.os.service.Sheduller;


/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {
    public static void main(String[] args) throws Exception {
        Settings settings = new Settings();
        System.out.println("Reading config.txt ...");
        String resultReadConfig = settings.readConfig();
        if (resultReadConfig.equals("")) {
            Sheduller sheduller = new Sheduller();
            sheduller.runTimer();
        } else {
            System.out.println(resultReadConfig);
        }
    }
}
