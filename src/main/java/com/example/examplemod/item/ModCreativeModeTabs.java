package com.example.examplemod.item;

//dont import items because that is the current location
import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.ExampleMod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITMES_TAB = CREATIVE_MODE_TABS.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                .title(Component.translatable("creativetab.examplemod.alexandrite_items"))
                .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.ALEXANDRITE.get());
                output.accept(ModItems.RAW_ALEXANDRITE.get());


                }).build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
            .withTabsBefore(ALEXANDRITE_ITMES_TAB.getId()) //makes sure items comes before blocks in the tab menu
            .title(Component.translatable("creativetab.examplemod.alexandrite_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
            output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
            output.accept(ModBlocks.ALEXANDRITE_ORE.get());
            output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

            
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
