package dev.vxrp.itemforge.util.peristentdatastorage;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PersistentDataStorageUtil {
    ItemStack itemStack;
    ItemMeta itemMeta;
    PersistentDataType<byte[], UUID> persistentDataType;

    public PersistentDataStorageUtil(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
        this.persistentDataType = new UUIDPersistentDataType();
    }

    public PersistentDataStorageUtil addUUID(NamespacedKey key, UUID uuid) {
        PersistentDataType<byte[], UUID> persistentDataType = new UUIDPersistentDataType();
        itemMeta.getPersistentDataContainer().set(key, persistentDataType, uuid);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

    public static class RetrieveStoredData {
        public static String retrieveString(ItemStack item, NamespacedKey key) {
            ItemMeta itemMeta = item.getItemMeta();
            PersistentDataContainer container = itemMeta.getPersistentDataContainer();

            if(container.has(key, PersistentDataType.STRING)) {
                return container.get(key, PersistentDataType.STRING);

            }
            return null;
        }
        public static Boolean retrieveAttributeExisting(List<ItemStack> itemStacks, NamespacedKey key, String attributeName) {
            List<Boolean> booleans = new ArrayList<>();
            for (ItemStack itemStack : itemStacks) {
                ItemMeta itemMeta = itemStack.getItemMeta();
                PersistentDataContainer container = itemMeta.getPersistentDataContainer();
                String retrievedString = container.get(key, PersistentDataType.STRING);
                assert retrievedString != null && !retrievedString.isEmpty();
                List<String> attributes = new ArrayList<String>(Arrays.asList(retrievedString.split(",")));
                booleans.add(attributes.contains(attributeName));
            }
            return booleans.contains(true);
        }
    }
}
