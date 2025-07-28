package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class unnick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        UUID u = p.getUniqueId();
        utils.setNick(u, p.getName());
        p.setDisplayName(utils.getPrefix(u) + p.getName());
        p.setPlayerListName(utils.getPrefix(u) + p.getName());
        /*Team team = utils.getPrefixNameTeam(p.getUniqueId());
        if (team != null) {
            team.removeEntry(utils.getNick(p.getUniqueId()));
            team.addEntry(p.getName());
        }*/

        p.sendMessage("unnicked");
        return true;
    }
}
