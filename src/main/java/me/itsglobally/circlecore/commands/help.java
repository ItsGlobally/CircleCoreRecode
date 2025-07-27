package me.itsglobally.circlecore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(
                "§d-----------------------------------------------------\n" +
                        "§bWelcome to §dCircle Network!" +
                        "§aIf you are looking for help, please join our Discord server!" +
                        "§bServer link: §rhttps://discord.gg/uU7QndhFws" +
                        "§d-----------------------------------------------------\n"
        );
        return true;
    }
}
