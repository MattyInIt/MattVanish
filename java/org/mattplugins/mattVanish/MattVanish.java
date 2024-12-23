package org.mattplugins.mattVanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class MattVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("vanish").setExecutor(new VanishCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}