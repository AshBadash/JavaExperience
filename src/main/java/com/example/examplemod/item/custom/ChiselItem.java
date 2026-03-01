package com.example.examplemod.item.custom;

import java.util.Map;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundSource;


public class ChiselItem extends Item{

    //ChiselItem will turn one block into another upon right click (useOn). 1st block in map pair is target, 2nd is trasnformation
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                        Blocks.STONE, Blocks.STONE_BRICKS,
                        Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                        Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                        Blocks.IRON_BLOCK, Blocks.DIAMOND_BLOCK,
                        Blocks.DIRT, ModBlocks.ALEXANDRITE_BLOCK.get() //modded blocks are registries, not actual block objects, so .get() is needed
            ); 


    public ChiselItem(Properties pProperties){
        super(pProperties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        //When we use the chisel on a block it can be used on:
        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){ //ensure we are on server side to transmutate blocks

                //Change the target block:
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                
                //Damage the chisel:
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                    (player) -> player.broadcastBreakEvent(EquipmentSlot.MAINHAND)
                ); //this breaking event has been updated from 1.17 to 1.20.1, where broadcastBreakEvent simplifies the call


                //Play a "chiseling" sound
                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;
    }

}
