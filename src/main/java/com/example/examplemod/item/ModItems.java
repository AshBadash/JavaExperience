package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraftforge.registries.DeferredRegister;

//Remaining imports automatically done and hidden with intelliJ:
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;



//registering the item in the game:

public class ModItems{ //make new item class
    public static final DeferredRegister<Item> ITEMS =
    DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    //^item alexandrite exists, but all properties are blank. We need to add JSON information to populate texture, name, tooltip, recipe all that good stuff.

    //alexandrite ore
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){ //make new item loadable
        ITEMS.register(eventBus); //register must also be called in ExampleMod constructor!
    }

}