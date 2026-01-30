package me.itsthatdev.coconut.features.commands.impl;

import me.itsthatdev.coconut.Coconut;
import me.itsthatdev.coconut.features.commands.Command;
import net.minecraft.ChatFormatting;

public class HelpCommand
        extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] commands) {
        HelpCommand.sendMessage("Commands: ");
        for (Command command : coconut.commandManager.getCommands()) {
            StringBuilder builder = new StringBuilder(ChatFormatting.GRAY.toString());
            builder.append(coconut.commandManager.getPrefix());
            builder.append(command.getName());
            builder.append(" ");
            for (String cmd : command.getCommands()) {
                builder.append(cmd);
                builder.append(" ");
            }
            HelpCommand.sendMessage(builder.toString());
        }
    }
}
