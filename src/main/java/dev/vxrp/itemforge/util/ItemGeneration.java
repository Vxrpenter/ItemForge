package dev.vxrp.itemforge.util;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.DataStorage.PersistentDataStorageUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemGeneration {
    public static ItemStack weapon(ItemForge plugin, Material material, Player player) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SHOW_WEAPON_ITEM_CREATOR)) {
            List<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize("<italic><gray>Created by - " + player.getName() + "<gray><italic>"));
            itemMeta.lore(lore);
        }
        item.setItemMeta(itemMeta);

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SAVE_WEAPON_CREATOR_IN_NBT)) {
            NamespacedKey key = new NamespacedKey(plugin, "player");
            return new PersistentDataStorageUtil(item)
                    .addUUID(key, player.getUniqueId())
                    .build();
        } else {
            return item;
        }
    }

    public static ItemStack armor(ItemForge plugin, Material material, Player player) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SHOW_ARMOR_ITEM_CREATOR)) {
            List<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize("<italic><gray>Created by - " + player.getName() + "<gray><italic>"));
            itemMeta.lore(lore);
        }
        item.setItemMeta(itemMeta);

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SAVE_ARMOR_CREATOR_IN_NBT)) {
            NamespacedKey key = new NamespacedKey(plugin, "player");
            return new PersistentDataStorageUtil(item)
                    .addUUID(key, player.getUniqueId())
                    .build();
        } else {
            return item;
        }
    }
}
