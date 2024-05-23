# About

## What is ItemForge
ItemForge is a complete overhaul of a minecraft combat system.
Or something like that, cause rn this
is still an alpha version.
With this plugin, I wanted to alter the way players fight, add some randomness
and overall make combat more interesting.

## TODO LIST
- [x] Alter Damage Calculation
- [ ] Crafting additions and changes
- [ ] Smithing
- [ ] New Weapons
- [ ] Wiki

# Already Existing Features

## Damage Calculation
Currently, the damage done by weapons is only manipulated by its durability.
If there is, for example, only 20% left, the damage will be reduced by 40%.
This calculation is actually
fully customizable in the `config.yml`

## Crafting Additions
You are now able to craft chainmail armor using chains

## Custom Item Attributes
Currently only working for armors

This adds multiple custom attributes to armors and tools, changing the experience you
have using those items. There will be at least one negative and positive Attribute applied to every
armor piece. Which armor pieces can get which attribute has to be defined in the config. 
Below you can find the current attributes, there will be more soon.

Advantages:
- `Agility` | Makes you faster
- `Pride` | Gives you strenght
- `Hard Shell` | Provides a chance that projectiles bounce off you
- `Hot Metal` | You are immune to fire for a customizable amount with a cooldown limiting this ability
- `Gliding` | Swords have a chance to not hit you

Disadvantages:
- `Flamable` | You take more fire damage
- `Slowing` | Slows you down
- `Soft` | (Still WIP)
- `A Hole in the Wall` | Projectiles do more damage

### Current Config
```ruby
#______  _     _  ______ _______ ______  _____        _____ _______ __   __
#|     \ |     | |_____/ |_____| |_____]   |   |        |      |      \_/
#|_____/ |_____| |    \_ |     | |_____] __|__ |_____ __|__    |       |

#States the damage an item does, depending on its durability.
#It works like this: The calculation starts at 0%, then the first state ends, for example, at 20%,
#and so on
percent_item_damaged:
  damaged_state_I:
    percent: 20
    reduced_damage: 20
  damaged_state_II:
    percent: 50
    reduced_damage: 30
  damaged_state_III:
    percent: 80
    reduced_damage: 40

#______ _______ __   _ ______   _____  _______      _______ _______ _______ _______ _______ _______ _______
#|_____/ |_____| | \  | |     \ |     | |  |  |      |______ |______ |______ |______ |          |    |______
#|    \_ |     | |  \_| |_____/ |_____| |  |  |      |______ |       |       |______ |_____     |    ______|

#!!! Currently, in early development (Experimental) !!!
activate_random_effects: true
random_effects:
  - POISON
  - WITHER

effect_settings:
  duration:
    value_I: 1
    value_II: 5
  amplifier:
    max: 2

#_  _  _ _______ _______  _____   _____  __   _      _______  ______ _______ _______ _______ _____ __   _  ______
#|  |  | |______ |_____| |_____] |     | | \  |      |       |_____/ |_____| |______    |      |   | \  | |  ____
#|__|__| |______ |     | |       |_____| |  \_|      |_____  |    \_ |     | |          |    __|__ |  \_| |_____|

affected_weapon_items: [ WOODEN_SWORD, STONE_SWORD, GOLDEN_SWORD, IRON_SWORD, DIAMOND_SWORD, NETHERITE_SWORD, WOODEN_AXE, STONE_AXE, GOLDEN_AXE, IRON_AXE, DIAMOND_AXE,
                         NETHERITE_AXE ]
save_weapon_creator_in_nbt: true

#_______  ______ _______  _____   ______      _______  ______ _______ _______ _______ _____ __   _  ______
#|_____| |_____/ |  |  | |     |  |_____/      |       |_____/ |_____| |______    |      |   | \  | |  ____
#|     | |    \_ |  |  | |_____|  |    \_      |_____  |    \_ |     | |          |    __|__ |  \_| |_____|

affected_armor_items: [ LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS, GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS, IRON_HELMET,
                        IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS, DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS, NETHERITE_HELMET,
                        NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_BOOTS, CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS ]
save_armor_creator_in_nbt: true

# _______ _______ _______  ______ _____ ______  _     _ _______ _______ _______
# |_____|    |       |    |_____/   |   |_____] |     |    |    |______ |______
# |     |    |       |    |    \_ __|__ |_____] |_____|    |    |______ ______|

armor_types:
  leather_armor:
    apply_attributes: true
    positive_attributes: [ attribute.agility ]
    negative_attributes: [ attribute.flamable ]
  chainmail_armor:
    apply_attributes: true
    positive_attributes: [ attribute.gliding ]
    negative_attributes: [ attribute.aHoleInTheWall ]
  golden_armor:
    apply_attributes: true
    positive_attributes: [ attribute.pride ]
    negative_attributes: [ attribute.soft ]
  iron_armor:
    apply_attributes: true
    positive_attributes: [ attribute.hardShell ]
    negative_attributes: [ attribute.slowing ]
  diamond_armor:
    apply_attributes: true
    positive_attributes: [ attribute.pride, attribute.hardShell ]
    negative_attributes: [ attribute.slowing ]
  netherite_armor:
    apply_attributes: true
    positive_attributes: [ attribute.hardShell, attribute.hotMetal ]
    negative_attributes: [ attribute.slowing ]

#Positive Attributes
attribute_agility:
  speed_level: 1
attribute_pride:
  strenght_level: 1
attribute_hard_shell:
  chance_of_avoiding: 25
attribute_hot_metal:
  time_until_damaging: 15
  cooldown: 30
attribute_gliding:
  chance_of_avoiding: 35

#Negative Attributes
attribute_flamable:
  damage_increase: 2
attribute_slowing:
  slowness_level: 1
attribute_soft:
  #WIP
attribute_a_hole_in_the_wall:
  projectile_damage_increase: 50
```

## Debugging Features
There are currently two different commands that help with debugging,
`/debuginfo` and `setitemdurability`.

| command           | args             | Permission                        | Features                                                                                |
|-------------------|------------------|-----------------------------------|-----------------------------------------------------------------------------------------|
| debuginfo         | show_damage_info | itemforge.debug.show_damage_info  | shows you various information like your current damage                                  |
| setitemdurability | none             | itemforge.debug.setitemdurability | pretty self explanatory (if no number is put in shows you the items current durability) |

> [!IMPORTANT]
> This is still an alpha if not a pre-alpha, so don't expect too much
