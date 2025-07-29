package me.itsglobally.circlecore;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.*;
import net.kyori.adventure.audience.Audience;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class utils {
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(JavaPlugin plugine) {
        plugin = plugine;
    }
    private static CircleCore instance;

    public static CircleCore getInstance() {
        return instance;
    }

    public static void setInstance(CircleCore instance) {
        utils.instance = instance;
    }

    private static final HashMap<UUID, String> prefixes = new HashMap<>();
    public static void setPrefix(UUID u, String p) {
        prefixes.put(u, p);
    }
    public static String getPrefix(UUID u) {
        return prefixes.get(u);
    }
    public static void chat(Player p, String s) {
        p.chat(ChatColor.translateAlternateColorCodes('&', s));
    }
    public static Audience getAudience(Player p) {
        return getInstance().adventure().player(p);
    }

    private static final HashMap<UUID, Boolean> vanished = new HashMap<>();
    public static void setVanished(UUID u, Boolean s) {
        vanished.put(u, s);
    }
    public static Boolean getVanished(UUID u) {
        return vanished.getOrDefault(u, false);
    }

    public static void appplynametag(String prefix, Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String safeTeamName = player.getName().length() > 16 ? player.getName().substring(0, 16) : player.getName();

        Team team = scoreboard.getTeam(safeTeamName);
        if (team != null) team.unregister();
        team = scoreboard.registerNewTeam(safeTeamName);

        team.setPrefix(prefix);
        team.addEntry(player.getName());

    }



}
