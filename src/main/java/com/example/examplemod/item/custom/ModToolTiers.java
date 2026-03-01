package com.example.examplemod.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeTier;
import com.example.examplemod.item.ModItems;

public class ModToolTiers {
    public static final ForgeTier ALEXANDRITE = new ForgeTier(
            4,                      // mining level (diamond = 3, netherite = 4)
            1800,                   // durability
            9.0f,                   // mining speed
            4.0f,                   // attack damage bonus
            18,                     // enchantability
            BlockTags.NEEDS_STONE_TOOL, // block tag required to mine (make sure this has no issues with previous definiitons of tools)
            () -> Tiers.NETHERITE.getRepairIngredient() // your custom ingredient here (replace netherite correctly)
    );
}
