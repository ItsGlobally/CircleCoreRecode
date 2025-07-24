package me.itsglobally.circlecore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.kyori.adventure.audience.Audience;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        LuckPerms lp = LuckPermsProvider.get();
        User user = lp.getUserManager().getUser(player.getUniqueId());
        String prefix = user != null ? user.getCachedData().getMetaData().getPrefix() + " " : null;
        if (prefix == null) prefix = "§7";
        utils.setPrefix(e.getPlayer().getUniqueId(), prefix);
        String formattedName = prefix + player.getName();

        player.setPlayerListName(formattedName);
        player.setDisplayName(formattedName);

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String safeTeamName = player.getName().length() > 16 ? player.getName().substring(0, 16) : player.getName();

        Team team = scoreboard.getTeam(safeTeamName);
        if (team != null) team.unregister();
        team = scoreboard.registerNewTeam(safeTeamName);

        team.setPrefix(prefix);
        team.addEntry(player.getName());
    }
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        e.setCancelled(true);
        Bukkit.broadcastMessage(/*utils.getPrefix(e.getPlayer().getUniqueId()) + */e.getPlayer().getDisplayName() + " §r» " + e.getMessage());
    }
}
