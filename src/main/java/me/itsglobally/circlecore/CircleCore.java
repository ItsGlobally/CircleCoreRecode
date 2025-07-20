package me.itsglobally.circlecore;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;
import me.itsglobally.circlecore.commands.*;
public final class CircleCore extends JavaPlugin {

    private BukkitAudiences adventure;

    @Override
    public void onEnable() {
        utils.setPlugin(this);
        utils.setInstance(this);
        this.adventure = BukkitAudiences.create(this);
        getCommand("circlecore").setTabCompleter(new gamemode());
        getCommand("circlecore").setExecutor(new gamemode());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public BukkitAudiences adventure() {
        return this.adventure;
    }
}
