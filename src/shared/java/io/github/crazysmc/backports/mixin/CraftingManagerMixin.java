package io.github.crazysmc.backports.mixin;

import net.minecraft.block.Block;
import net.minecraft.crafting.CraftingManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingManager.class)
public abstract class CraftingManagerMixin
{
  @Shadow
  abstract void registerShaped(ItemStack result, Object... args);

  @Shadow
  abstract void registerShapeless(ItemStack result, Object... args);

  @Inject(method = "<init>",
          at = @At(value = "INVOKE", target = "Ljava/util/Collections;sort(Ljava/util/List;Ljava/util/Comparator;)V"))
  private void init(CallbackInfo ci)
  {
    registerShaped(new ItemStack(Item.APPLE), "###", "###", "###", '#', Block.SAPLING);
    registerShapeless(new ItemStack(Item.STRING, 4), new ItemStack(Block.WOOL, 1, -1));
  }
}
