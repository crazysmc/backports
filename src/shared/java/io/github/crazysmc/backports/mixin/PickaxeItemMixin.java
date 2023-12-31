package io.github.crazysmc.backports.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(PickaxeItem.class)
public abstract class PickaxeItemMixin
{
  @Unique
  private static final Block[] EXTRA_EFFECTIVE_BLOCKS = new Block[] {
      Block.DISPENSER,
      Block.BRICKS,
      Block.OBSIDIAN,
      Block.FURNACE,
      Block.LIT_FURNACE,
      Block.STONE_STAIRS,
      Block.IRON_DOOR,
      Block.REDSTONE_ORE,
      Block.LIT_REDSTONE_ORE,
  };

  @Shadow
  private static Block[] EFFECTIVE_BLOCKS;

  @Redirect(method = "<init>",
            at = @At(value = "FIELD",
                     target = "Lnet/minecraft/item/PickaxeItem;EFFECTIVE_BLOCKS:[Lnet/minecraft/block/Block;"))
  private static Block[] getEffectiveBlocks()
  {
    Block[] concat = Arrays.copyOf(EFFECTIVE_BLOCKS, EFFECTIVE_BLOCKS.length + EXTRA_EFFECTIVE_BLOCKS.length);
    System.arraycopy(EXTRA_EFFECTIVE_BLOCKS, 0, concat, EFFECTIVE_BLOCKS.length, EXTRA_EFFECTIVE_BLOCKS.length);
    return concat;
  }
}
