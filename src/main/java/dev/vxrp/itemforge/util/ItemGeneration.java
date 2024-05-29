package dev.vxrp.itemforge.util;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.attributes.CustomAttributesLore;
import dev.vxrp.itemforge.util.peristentdatastorage.PersistentDataStorageUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemGeneration {
    public static ItemStack weapon(ItemForge plugin, Material material, Player player) {
        ItemStack item = new ItemStack(material);
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
        //Attributes
        NamespacedKey negativeAttributeKey = new NamespacedKey(plugin, "negative_attributes");
        NamespacedKey positiveAttributeKey = new NamespacedKey(plugin, "positive_attributes");
        //Attributes saved on items
            //Positive
            List<String> positive = new ArrayList<>();
            String itemGroup = MaterialTypes.returnArmorGroup(item.getType());
            for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList("armor_types."+itemGroup+".positive_attributes")).size(); i++) {
                positive.add((String) Objects.requireNonNull(plugin.getConfig().getList("armor_types."+itemGroup+".positive_attributes")).get(i));}
            //Negative
            List<String> negative = new ArrayList<>();
            for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList("armor_types."+itemGroup+".negative_attributes")).size(); i++) {
                negative.add((String) Objects.requireNonNull(plugin.getConfig().getList("armor_types."+itemGroup+".negative_attributes")).get(i));}
        //Applying
        if (plugin.getConfig().getBoolean("armor_types."+itemGroup+".apply_attributes")) {
            if (!MaterialTypes.containsArmor(item.getType())) return item;
            //Positive
            itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
            //Negative
            itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
        }
        item.setItemMeta(itemMeta);

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SAVE_ARMOR_CREATOR_IN_NBT)) {
            NamespacedKey key = new NamespacedKey(plugin, "player");
            return new PersistentDataStorageUtil(CustomAttributesLore.addLore(plugin, item))
                    .addUUID(key, player.getUniqueId())
                    .build();
        } else {
            return item;
        }
    }
}