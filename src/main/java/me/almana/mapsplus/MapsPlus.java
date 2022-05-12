package me.almana.mapsplus;

import me.almana.mapsplus.Commands.CustomMapCommand;
import me.almana.mapsplus.Commands.LogoCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MapsPlus extends JavaPlugin {

    private static MapsPlus plugin;

    @Override
    public void onEnable() {

        plugin = this;
        getConfig().options().copyDefaults();
        saveConfig();
        Bukkit.getPluginCommand("logo").setExecutor(new LogoCommand());
        Bukkit.getPluginCommand("custommap").setExecutor(new CustomMapCommand());
        this.getLogger().info("Plugin enabled.");
    }

    public static MapsPlus getPlugin() {
        return plugin;
    }
}
