package dev.vxrp.itemforge.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaterialTypes {
    public static List<Material> leather_armor() {
        return Arrays.asList(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
    }
    public static List<Material> chainmail_armor() {
        return Arrays.asList(Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS);
    }
    public static List<Material> golden_armor() {
        return Arrays.asList(Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS);
    }
    public static List<Material> iron_armor() {
        return Arrays.asList(Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS);
    }
    public static List<Material> diamond_armor() {
        return Arrays.asList(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS);
    }
    public static List<Material> netherite_armor() {
        return Arrays.asList(Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS);
    }
    public static List<Material> swords() {
        return Arrays.asList(Material.WOODEN_SWORD, Material.STONE_SWORD, Material.GOLDEN_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD);
    }

    public static List<ItemStack> armor(Player player) {
        List<ItemStack> armor = new ArrayList<>();
        if (player.getInventory().getHelmet() != null) {armor.add(player.getInventory().getHelmet());}
        if (player.getInventory().getChestplate() != null) {armor.add(player.getInventory().getChestplate());}
        if (player.getInventory().getLeggings() != null) {armor.add(player.getInventory().getLeggings());}
        if (player.getInventory().getBoots() != null) {armor.add(player.getInventory().getBoots());}
        return armor;
    }

    public static String returnArmorGroup(Material material) {
        for (int i = 0; i < leather_armor().size(); i++) {
            String armorType = "leather_armor";
            if (material == leather_armor().get(i)) return armorType;
        }
        for (int i = 0; i < chainmail_armor().size(); i++) {
            String armorType = "chainmail_armor";
            if (material == chainmail_armor().get(i)) return armorType;
        }
        for (int i = 0; i < golden_armor().size(); i++) {
            String armorType = "golden_armor";
            if (material == golden_armor().get(i)) return armorType;
        }
        for (int i = 0; i < iron_armor().size(); i++) {
            String armorType = "iron_armor";
            if (material == leather_armor().get(i)) return armorType;
        }
        for (int i = 0; i < diamond_armor().size(); i++) {
            String armorType = "diamond_armor";
            if (material == diamond_armor().get(i)) return armorType;
        }
        for (int i = 0; i < netherite_armor().size(); i++) {
            String armorType = "netherite_armor";
            if (material == netherite_armor().get(i)) return armorType;
        }
        return null;
    }

    public static Boolean containsArmor(Material material) {
        List<Material> armors = new ArrayList<>();
        armors.addAll(leather_armor());
        armors.addAll(chainmail_armor());
        armors.addAll(golden_armor());
        armors.addAll(diamond_armor());
        armors.addAll(netherite_armor());

        for (Material armor : armors) {
            if (material.equals(armor)) return true;
        }
        return false;
    }
}