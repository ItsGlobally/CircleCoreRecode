package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class nick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        if (strings.length < 1) {
            p.sendMessage("/nick (name)");
            return true;
        }
        UUID u = p.getUniqueId();
        utils.setNick(u, strings[0]);
        p.setDisplayName(utils.getPrefix(u) + strings[0]);
        p.setPlayerListName(utils.getPrefix(u) + strings[0]);
        /*Team team = utils.getPrefixNameTeam(p.getUniqueId());
        if (team != null) {
            team.removeEntry(p.getName());
            team.addEntry(utils.getNick(p.getUniqueId()));
        }*/

        p.sendMessage("nicked as " + strings[0]);
        return true;
    }
}
