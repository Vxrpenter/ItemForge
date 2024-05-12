package dev.vxrp.itemforge;

import dev.vxrp.itemforge.Events.DamageDealEvent;
import dev.vxrp.itemforge.Events.PlayerJoinEvent;
import dev.vxrp.itemforge.Events.debugging.DamageDealDebug;
import dev.vxrp.itemforge.commands.debugging.DebugInfo;
import dev.vxrp.itemforge.commands.debugging.SetItemDurability;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemForge extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Events();
        Commands();
    }

    public void Commands() {
        getCommand("debuginfo").setExecutor(new DebugInfo());
        getCommand("setdurability").setExecutor(new SetItemDurability());
    }
    public void Events() {
        getServer().getPluginManager().registerEvents(new DamageDealEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        //getServer().getPluginManager().registerEvents(new DamageDealDebug(this), this);
    }
}
