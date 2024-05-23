package dev.vxrp.itemforge.config;

public final class CONFIG {
    public final static class DAMAGE {
        //State I
        public final static String DAMAGED_STATE_I_PERCENT = "percent_item_damaged.damaged_state_I.percent";
        public final static String DAMAGED_STATE_I_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_I.reduced_damage";
        //State II
        public final static String DAMAGED_STATE_II_PERCENT = "percent_item_damaged.damaged_state_II.percent";
        public final static String DAMAGED_STATE_II_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_II.reduced_damage";
        //State III
        public final static String DAMAGED_STATE_III_PERCENT = "percent_item_damaged.damaged_state_III.percent";
        public final static String DAMAGED_STATE_III_REDUCED_DAMAGE = "percent_item_damaged.damaged_state_III.reduced_damage";
    }
    public final static class EFFECTS {
        //Active
        public final static String ACTIVATE_RANDOM_EFFECTS = "activate_random_effects";
        //Effects
        public final static String RANDOM_EFFECTS = "random_effects";
        //Duration
        public final static String DURATION_VALUE_I = "effect_settings.duration.value_I";
        public final static String DURATION_VALUE_II = "effect_settings.duration.value_II";
        //Amplifier
        public final static String AMPLIFIER_MAX = "effect_settings.amplifier.max";
    }
    public final static class CRAFTING {
        //Affected Weapons
        public final static String AFFECTED_WEAPON_ITEMS = "affected_weapon_items";
        //Affected Armor
        public final static String AFFECTED_ARMOR_ITEMS = "affected_armor_items";
        //Save Creator in NBT
        public final static String SAVE_WEAPON_CREATOR_IN_NBT = "save_weapon_creator_in_nbt";
        public final static String SAVE_ARMOR_CREATOR_IN_NBT = "save_armor_creator_in_nbt";
    }
    public final static class ATTRIBUTES {
        //Positive Attributes
        public final static String LEATHER_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.leather_armor.positive_attributes";
        public final static String CHAINMAIL_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.chainmail_armor.positive_attributes";
        public final static String GOLDEN_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.golden_armor.positive_attributes";
        public final static String IRON_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.iron_armor.positive_attributes";
        public final static String DIAMOND_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.diamond_armor.positive_attributes";
        public final static String NETHERITE_ARMOR_POSITIVE_ATTRIBUTES = "armor_types.netherite_armor.positive_attributes";
        //Negative Attributes
        public final static String LEATHER_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.leather_armor.negative_attributes";
        public final static String CHAINMAIL_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.chainmail_armor.negative_attributes";
        public final static String GOLDEN_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.golden_armor.negative_attributes";
        public final static String IRON_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.iron_armor.negative_attributes";
        public final static String DIAMOND_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.diamond_armor.negative_attributes";
        public final static String NETHERITE_ARMOR_NEGATIVE_ATTRIBUTES = "armor_types.netherite_armor.negative_attributes";
        //Apply Attributes
        public final static String APPLY_LEATHER_ARMOR_ATTRIBUTES = "armor_types.leather_armor.apply_attributes";
        public final static String APPLY_CHAINMAIL_ARMOR_ATTRIBUTES = "armor_types.chainmail_armor.apply_attributes";
        public final static String APPLY_GOLDEN_ARMOR_ATTRIBUTES = "armor_types.golden_armor.apply_attributes";
        public final static String APPLY_IRON_ARMOR_ATTRIBUTES = "armor_types.iron_armor.apply_attributes";
        public final static String APPLY_DIAMOND_ARMOR_ATTRIBUTES = "armor_types.diamond_armor.apply_attributes";
        public final static String APPLY_NETHERITE_ARMOR_ATTRIBUTES = "armor_types.netherite_armor.apply_attributes";
        //Positive Attributes Settings
        public final static String ATTRIBUTE_AGILITY_SPEED_LEVEL = "attribute_agility.speed_level";
        public final static String ATTRIBUTE_HOT_METAL_TIME_UNTIL_DAMAGING = "attribute_hot_metal.time_until_damaging";
        public final static String ATTRIBUTE_HOT_METAL_COOLDOWN = "attribute_hot_metal.cooldown";
        public final static String ATTRIBUTE_PRIDE_STRENGHT_LEVEL = "attribute_pride.strenght_level";
        public final static String ATTRIBUTE_HARD_SHELL_CHANCE_OF_AVOIDING = "attribute_hard_shell.chance_of_avoiding";
        public final static String ATTRIBUTE_GLIDING_CHANCE_OF_AVOIDING = "attribute_gliding.chance_of_avoiding";
        //Negative Attributes Settings
        public final static String ATTRIBUTE_FLAMABLE_DAMAGE_INCREASE = "attribute_flamable.damage_increase";
        public final static String ATTRIBUTE_SLOWING_LEVEL = "attribute_slowing.slowness_level";
        public final static String ATTRIBUTE_A_HOLE_IN_THE_WALL_PROJECTILE_DAMAGE_INCREASE = "attribute_a_hole_in_the_wall.projectile_damage_increase";
    }
}