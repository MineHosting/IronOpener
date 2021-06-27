package eu.mhsl.mc.ironopen;

import eu.mhsl.mc.ironopen.listeners.onBlockClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("IronOpener started...");
        getServer().getPluginManager().registerEvents(new onBlockClick(), this);
        Bukkit.getLogger().info("IronOpener loaded successfully!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("IronOpener disabled!");
    }
}
