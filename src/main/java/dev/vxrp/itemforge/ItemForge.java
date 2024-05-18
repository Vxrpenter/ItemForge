package dev.vxrp.itemforge;

import dev.vxrp.itemforge.Listeners.attributes.DamageEntityListener;
import dev.vxrp.itemforge.Listeners.attributes.ArmorChangeListener;
import dev.vxrp.itemforge.Listeners.attributes.DamageEntityByEntityListener;
import dev.vxrp.itemforge.Listeners.crafting.CraftListener;
import dev.vxrp.itemforge.Listeners.DamageDealListener;
import dev.vxrp.itemforge.Listeners.PlayerJoinListener;
import dev.vxrp.itemforge.Listeners.crafting.PrepareCraftListener;
import dev.vxrp.itemforge.Listeners.crafting.PrepareSmithingListener;
import dev.vxrp.itemforge.Listeners.crafting.SmithingListener;
import dev.vxrp.itemforge.Listeners.debugging.DebugDamageDealListener;
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
        getServer().getPluginManager().registerEvents(new DamageDealListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new DebugDamageDealListener(this), this);
        getServer().getPluginManager().registerEvents(new CraftListener(this), this);
        getServer().getPluginManager().registerEvents(new PrepareCraftListener(this), this);
        getServer().getPluginManager().registerEvents(new SmithingListener(this), this);
        getServer().getPluginManager().registerEvents(new PrepareSmithingListener(this), this);
        getServer().getPluginManager().registerEvents(new DamageEntityByEntityListener(this), this);
        getServer().getPluginManager().registerEvents(new ArmorChangeListener(this), this);
        getServer().getPluginManager().registerEvents(new DamageEntityListener(this), this);
    }
}
