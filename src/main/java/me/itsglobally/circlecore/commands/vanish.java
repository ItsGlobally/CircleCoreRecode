package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        utils.toggleVanished(p.getUniqueId());

        for (Player op : Bukkit.getOnlinePlayers()) {
            op.hidePlayer(p);
        }
        return true;
    }
}
