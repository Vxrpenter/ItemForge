package dev.vxrp.itemforge.util;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypes {
    public static List<Material> leather_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.LEATHER_HELMET);
        list.add(Material.LEATHER_CHESTPLATE);
        list.add(Material.LEATHER_LEGGINGS);
        list.add(Material.LEATHER_BOOTS);
        return list;
    }
    public static List<Material> chainmail_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.CHAINMAIL_HELMET);
        list.add(Material.CHAINMAIL_CHESTPLATE);
        list.add(Material.CHAINMAIL_LEGGINGS);
        list.add(Material.CHAINMAIL_BOOTS);
        return list;
    }
    public static List<Material> golden_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.GOLDEN_HELMET);
        list.add(Material.GOLDEN_CHESTPLATE);
        list.add(Material.GOLDEN_LEGGINGS);
        list.add(Material.GOLDEN_BOOTS);
        return list;
    }
    public static List<Material> iron_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.IRON_HELMET);
        list.add(Material.IRON_CHESTPLATE);
        list.add(Material.IRON_LEGGINGS);
        list.add(Material.IRON_BOOTS);
        return list;
    }
    public static List<Material> diamond_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.DIAMOND_HELMET);
        list.add(Material.DIAMOND_CHESTPLATE);
        list.add(Material.DIAMOND_LEGGINGS);
        list.add(Material.DIAMOND_BOOTS);
        return list;
    }
    public static List<Material> netherite_armor() {
        List<Material> list = new ArrayList<>();
        list.add(Material.NETHERITE_HELMET);
        list.add(Material.NETHERITE_CHESTPLATE);
        list.add(Material.NETHERITE_LEGGINGS);
        list.add(Material.NETHERITE_BOOTS);
        return list;
    }
}