package eu.endermite.effectsonhit;

import eu.endermite.effectsonhit.commands.ReloadCommand;
import eu.endermite.effectsonhit.configcache.ConfigCache;
import eu.endermite.effectsonhit.listeners.EntityDamageByEntityEvent;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class EffectsOnHit extends JavaPlugin {

    private static EffectsOnHit plugin;
    public static EffectsOnHit getPlugin(){ return plugin; }
    private ConfigCache cache;
    public ConfigCache getCache(){ return this.cache; }

    public void reloadCache() {
        cache = new ConfigCache(this.getConfig());
    }

    public void onEnable() {

        saveDefaultConfig();
        plugin = this;
        this.reloadCache();

        int pluginId = 6731;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityEvent(), this);
        getCommand("effectsonhitreload").setExecutor(new ReloadCommand());
        getLogger().info("Loaded!");
    }

}