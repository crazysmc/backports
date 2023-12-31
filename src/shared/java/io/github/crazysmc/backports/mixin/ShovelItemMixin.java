package io.github.crazysmc.backports.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(ShovelItem.class)
public abstract class ShovelItemMixin
{
  @Unique
  private static final Block[] EXTRA_EFFECTIVE_BLOCKS = new Block[] { Block.FARMLAND, Block.SOUL_SAND };

  @Shadow
  private static Block[] EFFECTIVE_BLOCKS;

  @Redirect(method = "<init>",
            at = @At(value = "FIELD",
                     target = "Lnet/minecraft/item/ShovelItem;EFFECTIVE_BLOCKS:[Lnet/minecraft/block/Block;"))
  private static Block[] getEffectiveBlocks()
  {
    Block[] concat = Arrays.copyOf(EFFECTIVE_BLOCKS, EFFECTIVE_BLOCKS.length + EXTRA_EFFECTIVE_BLOCKS.length);
    System.arraycopy(EXTRA_EFFECTIVE_BLOCKS, 0, concat, EFFECTIVE_BLOCKS.length, EXTRA_EFFECTIVE_BLOCKS.length);
    return concat;
  }
}
