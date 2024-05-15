package dev.vxrp.itemforge.Events.crafting;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.ItemGeneration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CraftEvent implements Listener {
    private final ItemForge plugin;
    public CraftEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack item = event.getRecipe().getResult();
        //Weapon List Initialization
        List<String> listedWeaponItems = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.CRAFTING.AFFECTED_WEAPON_ITEMS)).size(); i++) {
            listedWeaponItems.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.CRAFTING.AFFECTED_WEAPON_ITEMS)).get(i));
        }

        //Armor List Initialization
        List<String> listedArmorItems = new ArrayList<>();
        for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.CRAFTING.AFFECTED_ARMOR_ITEMS)).size(); i++) {
            listedArmorItems.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.CRAFTING.AFFECTED_ARMOR_ITEMS)).get(i));
        }

        //Item Check
        if (!listedWeaponItems.contains(item.getType().toString())) {
            if (listedArmorItems.contains(item.getType().toString())) {
                //SetItem
                for (HumanEntity he : event.getViewers()) {
                    event.getInventory().setResult(ItemGeneration.armor(plugin, item.getType(), (Player) he));
                }
            }
        } else {
            //SetItem
            for (HumanEntity he : event.getViewers()) {
                event.getInventory().setResult(ItemGeneration.armor(plugin, item.getType(), (Player) he));
            }
        }
    }
}