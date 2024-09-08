package com.illucit.ejbremote.server;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(RemoteCounter.class)
public class CounterBean implements RemoteCounter {

        private int count = 0;

    @Override
    public void increment() {
        this.count++;
    }

    @Override
    public void decrement() {
        this.count--;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}