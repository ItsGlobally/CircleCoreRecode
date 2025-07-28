package me.itsglobally.circlecore;

import net.kyori.adventure.audience.Audience;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

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
    public static void toggleVanished(UUID u) {
        vanished.put(u, !vanished.getOrDefault(u, false));
    }

    public static Boolean getVanished(UUID u) {
        return vanished.getOrDefault(u, false);
    }
    private static final HashMap<UUID, String> nick = new HashMap<>();
    public static void setNick(UUID u, String s) {
        nick.put(u, s);
    }

    public static String getNick(UUID u) {
        return nick.get(u);
    }
}
