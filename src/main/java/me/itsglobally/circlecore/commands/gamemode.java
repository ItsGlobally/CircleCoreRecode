package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        Audience a = utils.getInstance().adventure().player(p);
        switch (s) {
            case "gmc" -> {
                p.setGameMode(GameMode.CREATIVE);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.CREATIVE.toString()));
            }
            case "gms" ->{
                p.setGameMode(GameMode.SURVIVAL);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.SURVIVAL.toString()));
            }
            case "gma" ->{
                p.setGameMode(GameMode.ADVENTURE);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.ADVENTURE.toString()));
            }
            case "gmsp" -> {
                p.setGameMode(GameMode.SPECTATOR);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.SPECTATOR.toString()));
            }
            case "gm" -> {
                String mode = strings[0];
                GameMode gm= null;
                switch (mode) {
                    case "0" -> gm = GameMode.SURVIVAL;
                    case "1" -> gm = GameMode.CREATIVE;
                    case "2" -> gm = GameMode.ADVENTURE;
                    case "3" -> gm = GameMode.SPECTATOR;
                }
                if (gm == null) {
                    return true;
                }
                Player player = Bukkit.getPlayerExact(strings[1]);
                if (player == null) {
                    p.setGameMode(gm);// wait
                    Audience audience = utils.getInstance().adventure().player(player);
                    audience.sendActionBar(Component.text("§7a retard has changed ur fucking gm to " + gm.toString()));
                    a.sendActionBar(Component.text("§7u changed a retard's gm to " + gm.toString()));
                    return true;
                }
                player.setGameMode(gm);

            }
        }
        return true;
    }
}
