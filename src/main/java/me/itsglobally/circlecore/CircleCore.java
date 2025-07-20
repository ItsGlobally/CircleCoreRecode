package me.itsglobally.circlecore;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

public final class CircleCore extends JavaPlugin {

    private BukkitAudiences adventure;

    @Override
    public void onEnable() {
        utils.setPlugin(this);
        this.adventure = BukkitAudiences.create(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public BukkitAudiences adventure() {
        return this.adventure;
    }
}
