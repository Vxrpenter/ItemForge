package dev.vxrp.itemforge.Events;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.config.CONFIG;
import org.bukkit.Material;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class DamageDealEvent implements Listener {
    private final ItemForge plugin;
    public DamageDealEvent(ItemForge itemForge) {
        this.plugin = itemForge;
    }

    @EventHandler
    public void OnDamageDeal(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) return;
        Player player = (Player) event.getDamager();
        double damage;
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            //Durability
            ItemStack item = player.getInventory().getItemInMainHand();
            Damageable damageable = (Damageable) item.getItemMeta();
            double percent = (double) damageable.getDamage()/item.getType().getMaxDurability() * 100;

            double statePercentI = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_PERCENT);
            double statePercentII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_PERCENT);
            double statePercentIII = plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_PERCENT);


            if (percent <= statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_I_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
            if (percent <= statePercentII && percent > statePercentI) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_II_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
            if (percent <= statePercentIII && percent > statePercentII || percent > statePercentIII) {
                damage = event.getDamage() - event.getDamage()*plugin.getConfig().getDouble(CONFIG.DAMAGE.DAMAGED_STATE_III_REDUCED_DAMAGE)/100;
                event.setDamage(damage);
            }
        } else {
            damage = ThreadLocalRandom.current().nextDouble(1.0, 2.0);
            event.setDamage(damage);
        }
    }
}
