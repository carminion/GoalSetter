package com.catrops.goals.goalsetter;

import android.app.Application;
import android.content.res.Configuration;

import com.facebook.stetho.Stetho;

/**
 * Created by catrops on 8/25/16.
 */
public class GoalSetter extends Application {

    private static GoalSetter singleton;

    public static GoalSetter getInstance(){
        return singleton;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    /*
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
                        */
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
