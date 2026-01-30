package me.itsthatdev.coconut.event.impl;

import me.itsthatdev.coconut.event.Event;
import me.itsthatdev.coconut.event.Stage;

public class UpdateWalkingPlayerEvent extends Event {
    private final Stage stage;

    public UpdateWalkingPlayerEvent(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
