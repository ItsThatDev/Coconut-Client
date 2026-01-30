package me.itsthatdev.coconut.event.impl;

import me.itsthatdev.coconut.event.Event;

public class KeyInputEvent extends Event {
    private final int key;

    public KeyInputEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
