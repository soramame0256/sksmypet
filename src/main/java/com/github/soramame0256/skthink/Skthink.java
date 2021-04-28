package com.github.soramame0256.skthink;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.logging.Level;


public final class Skthink extends JavaPlugin {

    Skthink instance;
    SkriptAddon addon;

    @Override
    public void onEnable() {
        log("Activating Skthink...");

        instance = this;
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("com.github.soramame0256.skthink","elements");
        } catch(IOException e) {
            Bukkit.getLogger().log(Level.INFO, "Error occured in loading syntax");
            e.printStackTrace();
        }
        log("Activated Skthink! Have fun!");
    }

    @Override
    public void onDisable() {
        log("Skthink is deactivated. see you next time!");
    }
    public void log(String str) {
        Bukkit.getLogger().log(Level.INFO, str);
    }
    public Skthink getinstance() {
        return this;
    }
}
