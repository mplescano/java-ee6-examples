package com.illucit.ejbremote.server;

public interface RemoteCounter {

    void increment();

    void decrement();

    int getCount();
}