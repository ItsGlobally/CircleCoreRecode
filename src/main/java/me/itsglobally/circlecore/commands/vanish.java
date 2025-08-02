package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        UUID u = p.getUniqueId();
        if (strings.length == 0) {
            if (!utils.getVanished(u)) {
                utils.setVanished(u, true);
                p.sendMessage("§aYou're vanished!");
                for (Player op : Bukkit.getOnlinePlayers()) {
                    if (op.hasPermission("circlecore.canSeeVanish")) continue;
                    op.hidePlayer(p);
                }
                p.setDisplayName(p.getDisplayName() + utils.vanishSuffix(u));
            } else {
                utils.setVanished(u, false);
                p.sendMessage("§cYou're unvanished!");
                for (Player op : Bukkit.getOnlinePlayers()) {
                    op.showPlayer(p);
                }
                p.setDisplayName(p.getDisplayName() + utils.vanishSuffix(u));
            }
        } else if (strings.length == 1) {
            Player tg = Bukkit.getPlayerExact(strings[0]);
            if (tg == null) {
                p.sendMessage("§cPlayer not found.");
                return true;
            }
            UUID tgu = tg.getUniqueId();
            if (!utils.getVanished(tgu)) {
                utils.setVanished(tgu, true);
                p.sendMessage(tg.getDisplayName() + " §ais now vanished!");
                tg.sendMessage("§aYou are vanished because of " + p.getDisplayName());
                for (Player op : Bukkit.getOnlinePlayers()) {
                    if (op.hasPermission("circlecore.canSeeVanish")) continue;
                    op.hidePlayer(tg);
                }
                tg.setDisplayName(p.getDisplayName() + utils.vanishSuffix(u));
            } else {
                utils.setVanished(tgu, false);
                p.sendMessage(tg.getDisplayName() + " §cis now unvanished!");
                tg.sendMessage("§cYou are unvanished because of " + p.getDisplayName());
                for (Player op : Bukkit.getOnlinePlayers()) {
                    op.showPlayer(tg);
                }
                tg.setDisplayName(p.getDisplayName() + utils.vanishSuffix(u));
            }
        } else {
            return true;
        }
        return true;
    }
}
