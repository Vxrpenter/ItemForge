package dev.vxrp.itemforge.commands.development;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SetItemDurability implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) throws NullPointerException{
        if (sender instanceof Player player) {
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) return false;
            MiniMessage mm = MiniMessage.miniMessage();
            ItemStack item = player.getInventory().getItemInMainHand();
            Damageable damageable = (Damageable) item.getItemMeta();
            int maxHP = item.getType().getMaxDurability();
            int durability = maxHP - damageable.getDamage();

            if (args.length == 0) {
                player.sendMessage(mm.deserialize("<gray>The item you're holding has </gray><red>" + durability + "</red><gray>/</gray><red>" +
                        maxHP + "</red> <gray>durability left</gray>"));
            }
            else if (args.length == 1) {
                if (Integer.parseInt(args[0]) > maxHP) {
                    player.sendMessage(Component.text("The new durability can't exceed the maximum", NamedTextColor.RED));
                    return false;
                }
                int slot = player.getInventory().getHeldItemSlot();
                player.getInventory().remove(item);
                damageable.setDamage(Math.abs(Integer.parseInt(args[0]) - maxHP));
                item.setItemMeta(damageable);
                player.getInventory().setItem(slot, item);
            }
        }

        return false;
    }
}
