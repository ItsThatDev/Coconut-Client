package me.itsthatdev.coconut.features.commands.impl;

import me.itsthatdev.coconut.Coconut;
import me.itsthatdev.coconut.features.commands.Command;

public class PrefixCommand
        extends Command {
    public PrefixCommand() {
        super("prefix", new String[]{"<char>"});
    }

    @Override
    public void execute(String[] commands) {
        if (commands.length == 1) {
            Command.sendMessage("{green} Current prefix is %s ", coconut.commandManager.getPrefix());
            return;
        }
        coconut.commandManager.setPrefix(commands[0]);
        Command.sendMessage("Prefix changed to {gray} %s", commands[0]);
    }
}
