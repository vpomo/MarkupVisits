package com.vpomo.markupvisits.os.makeJAR;

import com.vpomo.markupvisits.os.service.Sheduller;
import com.vpomo.markupvisits.os.service.WebService;



/**
 * Created by Pomogalov on 04.10.2016.
 */
public class MainMarkUp {

    public static void main(String[] args) throws Exception {
        Sheduller sheduller = new Sheduller();
        sheduller.runTimer();
    }



}
