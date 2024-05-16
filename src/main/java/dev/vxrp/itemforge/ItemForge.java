package dev.vxrp.itemforge;

import dev.vxrp.itemforge.Events.crafting.CraftEvent;
import dev.vxrp.itemforge.Events.DamageDealEvent;
import dev.vxrp.itemforge.Events.PlayerJoinEvent;
import dev.vxrp.itemforge.Events.crafting.PrepareCraftEvent;
import dev.vxrp.itemforge.Events.crafting.PrepareSmithingEvent;
import dev.vxrp.itemforge.Events.crafting.SmithingEvent;
import dev.vxrp.itemforge.Events.debugging.DamageDealDebug;
import dev.vxrp.itemforge.commands.debugging.DebugInfo;
import dev.vxrp.itemforge.commands.debugging.SetItemDurability;
import dev.vxrp.itemforge.recipes.ChainmailRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ItemForge extends JavaPlugin {
    @Override
    public void onEnable() {
        ChainmailRecipe.initializeRecipes(this);
        saveDefaultConfig();
        Events();
        Commands();
    }

    public void Commands() {
        Objects.requireNonNull(getCommand("debuginfo")).setExecutor(new DebugInfo(this));
        Objects.requireNonNull(getCommand("setdurability")).setExecutor(new SetItemDurability());
    }
    public void Events() {
        getServer().getPluginManager().registerEvents(new DamageDealEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new DamageDealDebug(this), this);
        getServer().getPluginManager().registerEvents(new CraftEvent(this), this);
        getServer().getPluginManager().registerEvents(new PrepareCraftEvent(this), this);
        getServer().getPluginManager().registerEvents(new SmithingEvent(this), this);
        getServer().getPluginManager().registerEvents(new PrepareSmithingEvent(this), this);
    }
}
