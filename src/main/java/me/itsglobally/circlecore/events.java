package me.itsglobally.circlecore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.kyori.adventure.audience.Audience;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Team;

public class events implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent e, final Audience p) {
        Component header = Component.text("You're Retarded.\n").color(NamedTextColor.LIGHT_PURPLE);
        Component footer = Component.text("\nCircleNetwork V1.0").color(NamedTextColor.LIGHT_PURPLE);
        p.sendPlayerListHeaderAndFooter(header, footer);
        LuckPerms lp = LuckPermsProvider.get();
        User user = lp.getUserManager().getUser(e.getPlayer().getUniqueId());
        assert user != null;
        String prefix = user.getCachedData().getMetaData().getPrefix();
        utils.setPrefix(e.getPlayer().getUniqueId(), prefix);
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(e.getPlayer().getDisplayName());
        // team.addEntry(e.getPlayer().getDisplayName());
        assert prefix != null;
        team.setDisplayName(prefix.charAt(1) + e.getPlayer().getDisplayName());
        team.setPrefix(prefix);
    }
}
