package me.itsthatdev.coconut.features.commands.impl;

import me.itsthatdev.coconut.Coconut;
import me.itsthatdev.coconut.features.commands.Command;

public class FriendCommand
        extends Command {
    public FriendCommand() {
        super("friend", new String[]{"<add/del/name/clear>", "<name>"});
    }

    @Override
    public void execute(String[] commands) {
        if (commands.length == 1) {
            if (coconut.friendManager.getFriends().isEmpty()) {
                FriendCommand.sendMessage("Friend list empty D:.");
            } else {
                StringBuilder f = new StringBuilder("Friends: ");
                for (String friend : coconut.friendManager.getFriends()) {
                    try {
                        f.append(friend).append(", ");
                    } catch (Exception exception) {
                    }
                }
                FriendCommand.sendMessage(f.toString());
            }
            return;
        }
        if (commands.length == 2) {
            if (commands[0].equals("reset")) {
                coconut.friendManager.getFriends().clear();
                FriendCommand.sendMessage("Friends got reset.");
                return;
            }
            FriendCommand.sendMessage(commands[0] + (coconut.friendManager.isFriend(commands[0]) ? " is friended." : " isn't friended."));
            return;
        }
        if (commands.length >= 2) {
            switch (commands[0]) {
                case "add" -> {
                    coconut.friendManager.addFriend(commands[1]);
                    FriendCommand.sendMessage("{aqua} %s has been friended", commands[1]);
                    return;
                }
                case "del", "remove" -> {
                    coconut.friendManager.removeFriend(commands[1]);
                    FriendCommand.sendMessage("{red} %s has been unfriended", commands[1]);
                    return;
                }
            }
            FriendCommand.sendMessage("Unknown Command, try friend add/del (name)");
        }
    }
}
