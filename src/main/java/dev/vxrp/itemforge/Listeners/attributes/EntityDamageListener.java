package dev.vxrp.itemforge.Listeners.attributes;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.ATTRIBUTES;
import dev.vxrp.itemforge.config.CONFIG;
import dev.vxrp.itemforge.util.peristentdatastorage.PersistentDataStorageUtil;
import dev.vxrp.itemforge.util.MaterialTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.*;

public class EntityDamageListener implements Listener {
    //Hashmaps
    Map<UUID, Long> savedTime = new HashMap<>();
    Map<UUID, Long> lastDamage = new HashMap<>();

    private final ItemForge plugin;
    public EntityDamageListener(ItemForge itemForge) {
        this.plugin = itemForge;
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) return;
        Player player = (Player) event.getEntity();
        Random random = new Random();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

        //Keys
        NamespacedKey positiveKey = new NamespacedKey(plugin, ATTRIBUTES.POSITIVE_ATTRIBUTES);
        NamespacedKey negativeKey = new NamespacedKey(plugin, ATTRIBUTES.NEGATIVE_ATTRIBUTES);

        //Hot Metal
        if (damageCause == EntityDamageEvent.DamageCause.FIRE || damageCause == EntityDamageEvent.DamageCause.FIRE_TICK) {
            if (Boolean.TRUE.equals(PersistentDataStorageUtil.RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), positiveKey, ATTRIBUTES.POSITIVE.HOT_METAL))) {
                savedTime.putIfAbsent(player.getUniqueId(), System.currentTimeMillis());
                lastDamage.putIfAbsent(player.getUniqueId(), System.currentTimeMillis());

                if (System.currentTimeMillis() - lastDamage.get(player.getUniqueId()) >= plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_COOLDOWN)*1000L) {
                    savedTime.put(player.getUniqueId(), System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - savedTime.get(player.getUniqueId()) <= plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_TIME_UNTIL_DAMAGING)* 1000L) {
                    long mTime = System.currentTimeMillis()  - savedTime.get(player.getUniqueId());
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<gray> Time left until damaging - <red>" + (plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_TIME_UNTIL_DAMAGING)*1000L - mTime)/1000));
                    event.setCancelled(true);

                } else {
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<gray> Cooldown will reset in - <red>" + plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HOT_METAL_COOLDOWN)));
                }
                lastDamage.put(player.getUniqueId(), System.currentTimeMillis());
            }

        }
        if (damageCause == EntityDamageEvent.DamageCause.PROJECTILE) {
            //Hard Shell
            if (Boolean.TRUE.equals(PersistentDataStorageUtil.RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), positiveKey, ATTRIBUTES.POSITIVE.HARD_SHELL))) {
                if (random.nextInt(99) + 1 < plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_HARD_SHELL_CHANCE_OF_AVOIDING)) return;
                event.setCancelled(true);
            }
            //A Hole In The Wall
            if (Boolean.TRUE.equals(PersistentDataStorageUtil.RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), negativeKey, ATTRIBUTES.NEGATIVE.A_HOLE_I_THE_WALL))) {
                event.setDamage(event.getDamage()+event.getDamage()*plugin.getConfig().getDouble(CONFIG.ATTRIBUTES.ATTRIBUTE_A_HOLE_IN_THE_WALL_PROJECTILE_DAMAGE_INCREASE)/100);
            }
        }
        //Gliding
        if (damageCause == EntityDamageEvent.DamageCause.ENTITY_ATTACK || damageCause == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
            if (!MaterialTypes.swords().contains(player.getInventory().getItemInMainHand().getType())) return;
            if (Boolean.TRUE.equals(PersistentDataStorageUtil.RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), positiveKey, ATTRIBUTES.POSITIVE.GLIDING))) {
                if (random.nextInt(99) + 1 < plugin.getConfig().getInt(CONFIG.ATTRIBUTES.ATTRIBUTE_GLIDING_CHANCE_OF_AVOIDING)) return;
                event.setCancelled(true);
            }
        }
        //Flamable
        if (damageCause == EntityDamageEvent.DamageCause.FIRE || damageCause == EntityDamageEvent.DamageCause.FIRE_TICK) {
            if (Boolean.TRUE.equals(PersistentDataStorageUtil.RetrieveStoredData.retrieveAttributeExisting(MaterialTypes.armor(player), negativeKey, ATTRIBUTES.NEGATIVE.FLAMABLE))) {
                event.setDamage(event.getDamage()*plugin.getConfig().getDouble(CONFIG.ATTRIBUTES.ATTRIBUTE_FLAMABLE_DAMAGE_INCREASE));
            }
        }
    }
}