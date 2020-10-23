package com.example.instagramclone;


import  android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("nqOEQtmWglsuaU80wSdksfiDgT2Dwx1Nb1GVTKHW")
                .clientKey("7edI7glpIvo2uYYmNoMWwRHnGRis32WYL85mBFc0")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
