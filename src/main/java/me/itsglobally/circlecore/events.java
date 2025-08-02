package me.itsglobally.circlecore;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        for (Player ifvanished : Bukkit.getOnlinePlayers()) {
            if (utils.getVanished(ifvanished.getUniqueId())) {
                for (Player op : Bukkit.getOnlinePlayers()) {
                    if (op.hasPermission("circlecore.canSeeVanish")) continue;
                    op.hidePlayer(ifvanished);
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                LuckPerms lp = LuckPermsProvider.get();
                User user = lp.getUserManager().getUser(player.getUniqueId());
                String prefix = user != null ? user.getCachedData().getMetaData().getPrefix() : null;
                if (prefix == null) prefix = "§7";
                utils.setPrefix(e.getPlayer().getUniqueId(), prefix);
                String formattedName = prefix + player.getName();

                player.setPlayerListName(formattedName);
                player.setDisplayName(formattedName);
            }
        }.runTaskLater(utils.getPlugin(), 10L);
        if (!Objects.equals(utils.getNick(player.getUniqueId()), player.getName())) {
            String fname = utils.getPrefix(player.getUniqueId()) + utils.getNick(player.getUniqueId());
            player.setDisplayName(fname);
            player.setPlayerListName(fname);
        }
    }
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        e.setCancelled(true);
        if (api.getChatFormatHandleByCore()) Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + "§r» " + e.getMessage());
    }
}
