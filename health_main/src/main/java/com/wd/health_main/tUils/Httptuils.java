package com.wd.health_main.tUils;

import retrofit2.Retrofit;

public class Httptuils {
     private static Httptuils httptuils;
     private Retrofit retrofit;

      private Httptuils(){

    }

    public static Httptuils getHttptuils() {
         if (httptuils==null){
             httptuils = new Httptuils();
         }
        return httptuils;
    }
}
