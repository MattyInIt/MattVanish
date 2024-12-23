package org.mattplugins.mattVanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VanishCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    private static final String PREFIX = "§x§F§F§E§2§5§9§lM§x§F§F§D§B§5§8§la§x§F§F§D§5§5§7§lt§x§F§F§C§E§5§6§lt§x§F§F§C§8§5§5§lV§x§F§F§C§1§5§5§la§x§F§F§B§B§5§4§ln§x§F§F§B§4§5§3§li§x§F§F§A§E§5§2§ls§x§F§F§A§7§5§1§lh";

    public VanishCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + " Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        if (player.hasPermission("mattvanish.vanish")) {
            if (player.isInvisible()) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(plugin, player);
                }
                player.setInvisible(false);
                player.sendMessage(PREFIX + " You are now visible.");
            } else {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(plugin, player);
                }
                player.setInvisible(true);
                player.sendMessage(PREFIX + " You are now invisible.");
            }
            return true;
        } else {
            player.sendMessage(PREFIX + " You do not have permission to use this command.");
            return true;
        }
    }
}