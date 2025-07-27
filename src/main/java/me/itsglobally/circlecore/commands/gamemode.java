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
        Audience a = utils.getAudience(p);
        switch (s) {
            case "gmc" -> {
                p.setGameMode(GameMode.CREATIVE);
                a.sendActionBar(Component.text("§7You've changed your gamemode to " + GameMode.CREATIVE));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gms" ->{
                p.setGameMode(GameMode.SURVIVAL);
                a.sendActionBar(Component.text("§7You've changed your gamemode to " + GameMode.SURVIVAL));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gma" ->{
                p.setGameMode(GameMode.ADVENTURE);
                a.sendActionBar(Component.text("§7You've changed your gamemode to " + GameMode.ADVENTURE));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
            case "gmsp" -> {
                p.setGameMode(GameMode.SPECTATOR);
                a.sendActionBar(Component.text("§7You've changed your gamemode to " + GameMode.SPECTATOR));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);

            }
            case "gm" -> {
                if (strings.length < 1) {
                    p.sendMessage("§c/gamemode (0|1|2|3) (Player)");
                    return true;
                }
                String mode = strings[0];
                GameMode gm= null;
                switch (mode) {
                    case "0" -> gm = GameMode.SURVIVAL;
                    case "1" -> gm = GameMode.CREATIVE;
                    case "2" -> gm = GameMode.ADVENTURE;
                    case "3" -> gm = GameMode.SPECTATOR;
                }
                if (gm == null) {
                    p.sendMessage("§c/gamemode (0|1|2|3) (Player)");
                    return true;
                }
                Player player = Bukkit.getPlayerExact(strings[1]);
                if (player == null) {
                    p.sendMessage("§cThat player is not online!");
                    return true;
                }
                p.setGameMode(gm);
                Audience audience = utils.getAudience(player);
                audience.sendActionBar(Component.text(p.getDisplayName() + "§7 has changed your gamemode to " + gm));
                a.sendActionBar(Component.text("§7You have changed " + player.getDisplayName() + "§7's gamemode to " + gm));
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);

                player.setGameMode(gm);

            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) {
            return Collections.singletonList("ur-not-even-player");
        }
        if (s.equalsIgnoreCase("gm")) {
            if (strings.length == 1) {
                List.of("0", "1", "2", "3");
            } else if (strings.length == 2) {
                List<String> ol = new ArrayList<>();
                for (Player pe : Bukkit.getOnlinePlayers()) {
                    ol.add(pe.getName());
                }
                return ol;
            }
        }
        return Collections.singletonList("This-command-does-not-require-arg");
    }
}
