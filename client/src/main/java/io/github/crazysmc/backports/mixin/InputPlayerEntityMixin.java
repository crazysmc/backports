package io.github.crazysmc.backports.mixin;

import io.github.crazysmc.backports.Backports;
import net.minecraft.client.entity.living.player.InputPlayerEntity;
import net.minecraft.entity.living.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InputPlayerEntity.class)
public abstract class InputPlayerEntityMixin extends PlayerEntity
{
  private InputPlayerEntityMixin(World world)
  {
    super(world);
  }

  @Inject(method = "m_4021343", at = @At("HEAD"))
  public void m_4021343(CallbackInfo ci)
  {
    Backports.LOGGER.info("m_4021343 was called");
  }
}
