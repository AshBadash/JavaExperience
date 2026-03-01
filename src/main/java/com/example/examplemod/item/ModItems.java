package com.example.examplemod.item;

//Imports sequentially added as-needed from item mod development
import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.custom.ChiselItem;
import net.minecraftforge.registries.DeferredRegister;

//Remaining imports otherwise automatically done and hidden with intelliJ:
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


    //chisel. NOTE: this is a CUSTOM item, so it is its own class. NOTE: This item is a tool, so it has durability as well!
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));


    public static void register(IEventBus eventBus){ //make new item loadable
        ITEMS.register(eventBus); //register must also be called in ExampleMod constructor!
    }

}