package dev.vxrp.itemforge.recipes;

import dev.vxrp.itemforge.ItemForge;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;

public class ChainmailRecipe {
    public static void initializeRecipes(ItemForge plugin) {
        final ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        final ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        final ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        final ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);

        final NamespacedKey helmetKey = new NamespacedKey(plugin, "chainmail_helmet");
        final NamespacedKey chestplateKey = new NamespacedKey(plugin, "chainmail_chestplate");
        final NamespacedKey leggingsKey = new NamespacedKey(plugin, "chainmail_leggings");
        final NamespacedKey bootsKey = new NamespacedKey(plugin, "chainmail_boots");

        ShapedRecipe helmetRecipe = new ShapedRecipe(helmetKey, helmet);
        helmetRecipe.shape("CCC", "CAC");
        helmetRecipe.setCategory(CraftingBookCategory.EQUIPMENT);
        helmetRecipe.setIngredient('C', Material.CHAIN);
        helmetRecipe.setIngredient('A', Material.AIR);

        ShapedRecipe chestplateRecipe = new ShapedRecipe(chestplateKey, chestplate);
        chestplateRecipe.shape("CAC", "CCC", "CCC");
        chestplateRecipe.setCategory(CraftingBookCategory.EQUIPMENT);
        chestplateRecipe.setIngredient('C', Material.CHAIN);
        chestplateRecipe.setIngredient('A', Material.AIR);

        ShapedRecipe leggingsRecipe = new ShapedRecipe(leggingsKey, leggings);
        leggingsRecipe.shape("CCC", "CAC", "CAC");
        leggingsRecipe.setCategory(CraftingBookCategory.EQUIPMENT);
        leggingsRecipe.setIngredient('C', Material.CHAIN);
        leggingsRecipe.setIngredient('A', Material.AIR);

        ShapedRecipe bootsRecipe = new ShapedRecipe(bootsKey, boots);
        bootsRecipe.shape("AAA", "CAC", "CAC");
        bootsRecipe.setCategory(CraftingBookCategory.EQUIPMENT);
        bootsRecipe.setIngredient('C', Material.CHAIN);
        bootsRecipe.setIngredient('A', Material.AIR);

        Bukkit.addRecipe(helmetRecipe);
        Bukkit.addRecipe(chestplateRecipe);
        Bukkit.addRecipe(leggingsRecipe);
        Bukkit.addRecipe(bootsRecipe);
    }
}
