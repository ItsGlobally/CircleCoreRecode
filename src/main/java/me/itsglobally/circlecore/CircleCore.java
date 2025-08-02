package me.itsglobally.circlecore;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;
import me.itsglobally.circlecore.commands.*;
public final class CircleCore extends JavaPlugin {

    private BukkitAudiences adventure;

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        utils.setPlugin(this);
        utils.setInstance(this);
        this.adventure = BukkitAudiences.create(this);
        getCommand("gamemode").setTabCompleter(new gamemode());
        getCommand("gamemode").setExecutor(new gamemode());
        getCommand("help").setExecutor(new help());
        getCommand("vanish").setExecutor(new vanish());
        getCommand("nick").setExecutor(new nick());
        getServer().getPluginManager().registerEvents(new events(), this);
        protocolManager = ProtocolLibrary.getProtocolManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public BukkitAudiences adventure() {
        return this.adventure;
    }

    public ProtocolManager protocolMgr() { return this.protocolManager; }
}
