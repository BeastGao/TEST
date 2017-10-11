package com.example.broadcastbestpracticelx;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高繁 on 2017/10/11.
 */

public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }


}
