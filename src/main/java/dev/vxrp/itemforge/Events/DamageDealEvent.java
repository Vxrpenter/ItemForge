package dev.vxrp.itemforge.Events;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageDealEvent implements Listener {
    @EventHandler
    public void OnDamageDeal(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() != EntityType.PLAYER) return;
        Player player = (Player) event.getDamager();
        double damage = event.getDamage();

        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            //
            //Durability
            //
            ItemStack item = player.getInventory().getItemInMainHand();
            Damageable damageable = (Damageable) item.getItemMeta();
            double durability = damageable.getHealth();
            double percent = durability/damageable.getMaxHealth() * 100;

            if (percent > 80) {
                event.setDamage(damage - 2);
            }
            if (percent > 50) {
                event.setDamage(damage - 3);
            }
            if (percent > 20) {
                event.setDamage(damage - 4);
            }

        }
    }
}
