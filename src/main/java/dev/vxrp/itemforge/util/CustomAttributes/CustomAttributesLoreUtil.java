package dev.vxrp.itemforge.util.CustomAttributes;

import dev.vxrp.itemforge.ItemForge;
import dev.vxrp.itemforge.util.DataStorage.RetrieveStoredData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomAttributesLoreUtil {
    public static MiniMessage mm = MiniMessage.miniMessage();
    //Positive Armor Attributes
    public static List<Component> agility() {
        List<Component> agility = new ArrayList<>();
        agility.add(mm.deserialize("<yellow>Agility <gray>- Lighter armor provides better"));
        agility.add(mm.deserialize("<gray>movement speed"));
        return agility;
    }
    public static List<Component> pride() {
        List<Component> pride = new ArrayList<>();
        pride.add(mm.deserialize("<color:#ffd700>Pride <gray>- Everyone is just looking at you"));
        pride.add(mm.deserialize("<gray>leading to you gaining some more strength"));
        return pride;
    }
    public static List<Component> hardShell() {
        List<Component> hardShell = new ArrayList<>();
        hardShell.add(mm.deserialize("<color:#bf5d37>Hard Shell <gray>- Projectiles are more likely to bounce off"));
        hardShell.add(mm.deserialize("<gray>then to pierce you"));
        return hardShell;
    }
    public static List<Component> hotMetal() {
        List<Component> hotMetal = new ArrayList<>();
        hotMetal.add(mm.deserialize("<red>Hot Metal <gray>- Fire doesn't affect you anymore"));
        hotMetal.add(mm.deserialize("<gray>if you can extinguish it fast enough "));
        return hotMetal;
    }
    public static List<Component> gliding() {
        List<Component> gliding = new ArrayList<>();
        gliding.add(mm.deserialize("<white>Gliding <gray>- Swords may glide off your armor"));
        return gliding;
    }

    //Negative Armor Attributes
    public static List<Component> flamable() {
        List<Component> flamable = new ArrayList<>();
        flamable.add(mm.deserialize("<color:#ffa500>Flamable <gray>- Items that easily catch on fire"));
        flamable.add(mm.deserialize("<gray>should be kept wet"));
        return flamable;
    }
    public static List<Component> slowing() {
        List<Component> slowing = new ArrayList<>();
        slowing.add(mm.deserialize("<color:#2a2a2a>Slowing <gray>- Heavy armor or weaponry make movement"));
        slowing.add(mm.deserialize("<gray>much more difficult"));
        return slowing;
    }
    public static List<Component> soft() {
        List<Component> slowing = new ArrayList<>();
        slowing.add(mm.deserialize("<color:#fa8072>Soft <gray>- Easily deformable"));
        return slowing;
    }
    public static List<Component> aHoleInTheWall() {
        List<Component> aHoleInTheWall = new ArrayList<>();
        aHoleInTheWall.add(mm.deserialize("<color:#a52a2a>A Hole in the Wall <gray>- Projectiles glide through your armor"));
        return aHoleInTheWall;
    }

    //Adding Lore
    public static ItemStack addLore(ItemForge plugin, ItemStack item) {
        String positiveAttributes = RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "positive_attributes"));
        String negativeAttributes = RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "negative_attributes"));

        if (positiveAttributes != null || negativeAttributes != null) {
            //Lore list
            List<Component> lore = new ArrayList<>();
            //Positive Armor Attributes
            assert positiveAttributes != null;
            lore.add(mm.deserialize("<gray>(<green>+<gray>) Advantages:"));
            lore.add(Component.text(" "));
            if (positiveAttributes.contains("attribute.agility")) {
                lore.addAll(agility());
                lore.add(Component.text(" "));
            }
            if (positiveAttributes.contains("attribute.pride")) {
                lore.addAll(pride());
                lore.add(Component.text(" "));
            }
            if (positiveAttributes.contains("attribute.hardShell")) {
                lore.addAll(hardShell());
                lore.add(Component.text(" "));
            }
            if (positiveAttributes.contains("attribute.hotMetal")) {
                lore.addAll(hotMetal());
                lore.add(Component.text(" "));
            }
            if (positiveAttributes.contains("attribute.gliding")) {
                lore.addAll(gliding());
                lore.add(Component.text(" "));
            }
            //Negative Armor Attributes
            assert negativeAttributes != null;
            lore.add(mm.deserialize("<gray>(<red>-<gray>) Disadvantages:"));
            lore.add(Component.text(" "));
            if (negativeAttributes.contains("attribute.flamable")) {
                lore.addAll(flamable());
                lore.add(Component.text(" "));
            }
            if (negativeAttributes.contains("attribute.slowing")) {
                lore.addAll(slowing());
                lore.add(Component.text(" "));
            }
            if (negativeAttributes.contains("attribute.soft")) {
                lore.addAll(soft());
                lore.add(Component.text(" "));
            }
            if (negativeAttributes.contains("attribute.aHoleInTheWall")) {
                lore.addAll(aHoleInTheWall());
            }
            item.lore(lore);
            return item;
        }
        return item;
    }

    //Removing Lore
    public static ItemStack removeLore(ItemForge plugin ,ItemStack item) {
        String positiveAttributes = RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "positive_attributes"));
        String negativeAttributes = RetrieveStoredData.retrieveString(item, new NamespacedKey(plugin, "negative_attributes"));

        if (positiveAttributes != null || negativeAttributes != null) {
            List<Component> lore = item.lore();
            assert lore != null;
            //Positive Armor Attributes
            if (new HashSet<>(lore).containsAll(agility())) {
                lore.removeAll(agility());
            }
            if (new HashSet<>(lore).containsAll(pride())) {
                lore.removeAll(pride());
            }
            if (new HashSet<>(lore).containsAll(hardShell())) {
                lore.removeAll(hardShell());
            }
            if (new HashSet<>(lore).containsAll(hotMetal())) {
                lore.removeAll(hotMetal());
            }
            if (new HashSet<>(lore).containsAll(gliding())) {
                lore.removeAll(gliding());
            }
            //Negative Armor Attributes
            if (new HashSet<>(lore).containsAll(flamable())) {
                lore.removeAll(flamable());
            }
            if (new HashSet<>(lore).containsAll(slowing())) {
                lore.removeAll(slowing());
            }
            if (new HashSet<>(lore).containsAll(soft())) {
                lore.removeAll(soft());
            }
            if (new HashSet<>(lore).containsAll(aHoleInTheWall())) {
                lore.removeAll(aHoleInTheWall());
            }
            item.lore(lore);
            return item;
        }
        return item;
    }
}
