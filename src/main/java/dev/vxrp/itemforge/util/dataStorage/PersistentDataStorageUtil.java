package dev.vxrp.itemforge.util.dataStorage;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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
}
