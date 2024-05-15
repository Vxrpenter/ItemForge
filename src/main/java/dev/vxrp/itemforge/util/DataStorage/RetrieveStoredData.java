package dev.vxrp.itemforge.util.DataStorage;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

public class RetrieveStoredData {
    public static String retrieveString(ItemStack item, NamespacedKey key) {
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        if(container.has(key , UUIDPersistentDataType.STRING)) {
            return container.get(key, UUIDPersistentDataType.STRING);

        }
        return null;
    }
}
