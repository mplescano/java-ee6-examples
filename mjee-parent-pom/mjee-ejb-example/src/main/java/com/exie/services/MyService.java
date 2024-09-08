package com.exie.services;

import com.exie.mjeedom.MyServiceRemote;
import com.exie.mjeedom.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.prefs.Preferences;
import javax.ejb.Stateless;

/**
 *
 * @author mikael
 */
@Stateless
public class MyService implements MyServiceRemote {
    Map<String,User> users = new HashMap<>();

    public String getHello(String name) {
        User user = users.computeIfAbsent(name, kname -> new User(kname, new Date()));
        return "Hello " + user.getName();
    }


    public long ping() {
        return System.currentTimeMillis();
    }

    public String getUserHome() {
        Preferences p = Preferences.userNodeForPackage(MyService.class);
        String retVal = p.get("uuid", UUID.randomUUID().toString());

        System.out.println("getUserHome: '" + retVal + "'");

        return retVal;
    }
}
