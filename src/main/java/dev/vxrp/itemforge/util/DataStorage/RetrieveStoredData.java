package dev.vxrp.itemforge.util.DataStorage;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetrieveStoredData {
    public static String retrieveString(ItemStack item, NamespacedKey key) {
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        if(container.has(key, PersistentDataType.STRING)) {
            return container.get(key, PersistentDataType.STRING);

        }
        return null;
    }
    public static Boolean retrieveAttributeExisting(List<ItemStack> itemStacks, NamespacedKey key, String attributeName) {
        for (ItemStack itemStack : itemStacks) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            PersistentDataContainer container = itemMeta.getPersistentDataContainer();
            String retrievedString = container.get(key, PersistentDataType.STRING);
            assert retrievedString != null;
            List<String> attributes = new ArrayList<String>(Arrays.asList(retrievedString.split(",")));

            return attributes.contains(attributeName);
        }
        return null;
    }
}
