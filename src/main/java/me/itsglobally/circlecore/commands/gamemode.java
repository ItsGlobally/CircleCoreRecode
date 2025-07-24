package me.itsglobally.circlecore.commands;

import me.itsglobally.circlecore.utils;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gamemode implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return true;
        }
        Audience a = utils.getInstance().adventure().player(p);
        switch (s) {
            case "gmc" -> {
                p.setGameMode(GameMode.CREATIVE);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.CREATIVE));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gms" ->{
                p.setGameMode(GameMode.SURVIVAL);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.SURVIVAL));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gma" ->{
                p.setGameMode(GameMode.ADVENTURE);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.ADVENTURE));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gmsp" -> {
                p.setGameMode(GameMode.SPECTATOR);
                a.sendActionBar(Component.text("u changed ur shitty gm to " + GameMode.SPECTATOR));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);

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
                    p.setGameMode(gm);
                    Audience audience = utils.getInstance().adventure().player(player);
                    audience.sendActionBar(Component.text("§7a retard has changed ur fucking gm to " + gm));
                    a.sendActionBar(Component.text("§7u changed a retard's gm to " + gm));
                    return true;
                }
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);

                player.setGameMode(gm);

            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return Collections.singletonList("u_fucking_retarded");
        }
        if (s.equalsIgnoreCase("gm")) {
            if (strings.length == 1) {
                List.of("1", "2", "3", "4");
            } else if (strings.length == 2) {
                List<String> ol = new ArrayList<>();
                for (Player pe : Bukkit.getOnlinePlayers()) {
                    ol.add(pe.getName());
                }
                return ol;
            }
        }
        return Collections.singletonList("bro_is_retarded_omfg");
    }
}
