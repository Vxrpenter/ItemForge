package dev.vxrp.itemforge.util;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.CustomAttributes.CustomAttributesLoreUtil;
import dev.vxrp.itemforge.util.DataStorage.PersistentDataStorageUtil;
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
        if (MaterialTypes.leather_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_LEATHER_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.LEATHER_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.LEATHER_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.LEATHER_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.LEATHER_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        if (MaterialTypes.chainmail_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_CHAINMAIL_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.CHAINMAIL_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.CHAINMAIL_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.CHAINMAIL_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.CHAINMAIL_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        if (MaterialTypes.golden_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_GOLDEN_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.GOLDEN_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.GOLDEN_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.GOLDEN_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.GOLDEN_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        if (MaterialTypes.iron_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_IRON_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.IRON_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.IRON_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.IRON_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.IRON_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        if (MaterialTypes.diamond_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_DIAMOND_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.DIAMOND_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.DIAMOND_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.DIAMOND_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.DIAMOND_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        if (MaterialTypes.netherite_armor().contains(item.getType())) {
            if (plugin.getConfig().getBoolean(CONFIG.ATTRIBUTES.APPLY_NETHERITE_ARMOR_ATTRIBUTES)) {
                //Positive
                List<String> positive = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.NETHERITE_ARMOR_POSITIVE_ATTRIBUTES)).size(); i++) {
                    positive.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.NETHERITE_ARMOR_POSITIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(positiveAttributeKey, PersistentDataType.STRING , String.join(",", positive));
                //Negative
                List<String> negative = new ArrayList<>();
                for (int i = 0; i < Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.NETHERITE_ARMOR_NEGATIVE_ATTRIBUTES)).size(); i++) {
                    negative.add((String) Objects.requireNonNull(plugin.getConfig().getList(CONFIG.ATTRIBUTES.NETHERITE_ARMOR_NEGATIVE_ATTRIBUTES)).get(i));
                }
                itemMeta.getPersistentDataContainer().set(negativeAttributeKey, PersistentDataType.STRING , String.join(",", negative));
            }
        }
        item.setItemMeta(itemMeta);

        if (plugin.getConfig().getBoolean(CONFIG.CRAFTING.SAVE_ARMOR_CREATOR_IN_NBT)) {
            NamespacedKey key = new NamespacedKey(plugin, "player");
            return new PersistentDataStorageUtil(CustomAttributesLoreUtil.addLore(plugin, item))
                    .addUUID(key, player.getUniqueId())
                    .build();
        } else {
            return item;
        }
    }
}