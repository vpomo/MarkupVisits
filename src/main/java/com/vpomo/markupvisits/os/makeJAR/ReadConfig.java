package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.model.Settings;

/**
 * Created by Pomogalov on 19.10.2016.
 */
public class ReadConfig {
    public static void main (String[] args) {
        Settings settings = new Settings();
        System.out.println("Reading config.txt ...");
        String resultReadConfig = settings.readConfig();
        if (resultReadConfig.equals("")) {

        } else { System.out.println(resultReadConfig);

        }
    }
}
