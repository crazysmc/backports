package io.github.crazysmc.backports.mixin;

import io.github.crazysmc.backports.BackportsClient;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin
{
  @ModifyConstant(method = "tick", constant = @Constant(intValue = 63))
  public int tick(int constant)
  {
    return BackportsClient.perspectiveKey.keyCode;
  }
}
