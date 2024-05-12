# About

## What is ItemForge
ItemForge is a complete overhaul of minecraft combat system. Or something like this, because rn this
is still an Alpha. With this plugin I wanted to alter the way players fight, add some randomness
and overall make combat more interesting.

## TODO LIST
- [x] Alter Damage Calculation
- [ ] Smithing
- [ ] New Weapons

# Already Existing Features

## Damage Calculation
Currently, the damage done by weapons is only manipulated by its durability.
If there is, for example, only 20% left the damage will be reduced by 40%. This calculation is actually
fully customizable in the `config.yml`

### Current Config
```ruby
#States the damage an item does, depending on its durability.
#It works like this: The calculation starts at 0%, then the first state ends, for example at 20%
#and so on
#~ All values represent ' % ' of MaxHp/Damage
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
```

## Debug Features
There are currently two different commands that help with debugging,
`/debuginfo` and `setitemdurability`.

| command            | args           | Features                                                                                |
|--------------------|----------------|-----------------------------------------------------------------------------------------|
| debuginfo          | show_damage_info | shows you various information like your current damage                                  |
| setitemdurability  | none           | pretty self explanatory (if no number is put in shows you the items current durability) |

> [!IMPORTANT]
> This is still a alpha if not a pre-alpha, so don't expect too much yet