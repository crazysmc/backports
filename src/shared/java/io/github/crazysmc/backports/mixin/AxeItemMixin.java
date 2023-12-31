package io.github.crazysmc.backports.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin
{
  @Unique
  private static final Block[] EXTRA_EFFECTIVE_BLOCKS = new Block[] {
      Block.NOTEBLOCK,
      Block.OAK_STAIRS,
      Block.CRAFTING_TABLE,
      Block.STANDING_SIGN,
      Block.WOODEN_DOOR,
      Block.LADDER,
      Block.WALL_SIGN,
      Block.WOODEN_PRESSURE_PLATE,
      Block.JUKEBOX,
      Block.FENCE,
  };

  @Shadow
  private static Block[] EFFECTIVE_BLOCKS;

  @Redirect(method = "<init>",
            at = @At(value = "FIELD",
                     target = "Lnet/minecraft/item/AxeItem;EFFECTIVE_BLOCKS:[Lnet/minecraft/block/Block;"))
  private static Block[] getEffectiveBlocks()
  {
    Block[] concat = Arrays.copyOf(EFFECTIVE_BLOCKS, EFFECTIVE_BLOCKS.length + EXTRA_EFFECTIVE_BLOCKS.length);
    System.arraycopy(EXTRA_EFFECTIVE_BLOCKS, 0, concat, EFFECTIVE_BLOCKS.length, EXTRA_EFFECTIVE_BLOCKS.length);
    return concat;
  }
}
