package de.hszg.notenprogramm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubSub {

    private static final Map<String, List<Runnable>> subscribers = new HashMap<>();

    public static void subscribe(String key, Runnable runnable) {
        if(!subscribers.containsKey(key)) {
            subscribers.put(key, new ArrayList<>());
        }

        subscribers.get(key).add(runnable);
    }

    public static void unsubscribe(String key, Runnable runnable) {
        if(subscribers.containsKey(key)) {
            subscribers.get(key).remove(runnable);
        }
    }

    public static void publish(String key) {
        if(subscribers.containsKey(key)) {
            subscribers.get(key).forEach(Runnable::run);
        }
    }
}
