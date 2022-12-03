package com.example.allnetworkads;

import android.content.Context;
import android.util.Log;

import com.example.allnetworkads.adslib.Constants;
import com.example.allnetworkads.adslib.SharedPrefUtils;

public class AdsCounter {

    private static final String COUNTER = "counter";


    private static int getCount(Context context) {
        return SharedPrefUtils.getIntData(context, COUNTER);
    }

    private static void resetCount(Context context) {
        SharedPrefUtils.saveData(context, COUNTER, 0);
    }

    private static void addCount(Context context) {
        int count = getCount(context);
        count += 1;
        SharedPrefUtils.saveData(context, COUNTER, count);

    }

    public static boolean isShowAd(Context context) {
        int count = getCount(context);
        int matchCounter = 0;
        try {
            matchCounter = Integer.parseInt(SharedPrefUtils.getStringData(context, Constants.AD_COUNTER));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (count == matchCounter) {
            resetCount(context);
            return true;
        } else {
            addCount(context);
            return false;
        }
    }
}
