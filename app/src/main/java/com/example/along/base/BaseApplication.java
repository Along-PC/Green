package com.example.along.base;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by meridian on 2018/2/2.
 */

public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(L) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("Along")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

}
