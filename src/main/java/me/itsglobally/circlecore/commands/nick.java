package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import me.neznamy.tab.api.nametag.NameTagManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        if (strings.length < 1) {
            p.sendMessage("§c/nick (name)");
            return true;
        }
        switch (s) {
            case "nick" -> {
                String name = strings[0];
                String fname = utils.getPrefix(p.getUniqueId()) + name;
                p.setDisplayName(fname);
                p.setPlayerListName(fname);
                utils.setNick(p.getUniqueId(), name);
                p.setCustomName(p.getDisplayName());
                p.sendMessage("§aNicked as " + fname);
            }
            case "unnick" -> {
                String fname = utils.getPrefix(p.getUniqueId()) + p.getName();
                p.setDisplayName(fname);
                p.setPlayerListName(fname);
                utils.setNick(p.getUniqueId(), p.getName());
                p.setCustomName(p.getDisplayName());
                p.sendMessage("§aUnnicked");
            }
        }
        return true;
    }
}
