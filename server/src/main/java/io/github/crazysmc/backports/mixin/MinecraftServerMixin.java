package io.github.crazysmc.backports.mixin;

import io.github.crazysmc.backports.Backports;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.WorldStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin
{
  @Inject(method = "loadWorld", at = @At("HEAD"))
  public void loadWorld(WorldStorageSource storageSource, String worldDirName, long seed, CallbackInfo ci)
  {
    Backports.LOGGER.info("Loading world '{}' with seed {}", worldDirName, seed);
  }
}
