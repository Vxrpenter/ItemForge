package dev.vxrp.itemforge;

import dev.vxrp.itemforge.Events.DamageDealEvent;
import dev.vxrp.itemforge.commands.development.SetItemDurability;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemForge extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Events();
        Commands();
    }

    public void Commands() {
        getCommand("setdurability").setExecutor(new SetItemDurability());
    }
    public void Events() {
        getServer().getPluginManager().registerEvents(new DamageDealEvent(this), this);
    }
}
