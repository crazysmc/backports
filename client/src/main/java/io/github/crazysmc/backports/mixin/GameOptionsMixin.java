package io.github.crazysmc.backports.mixin;

import io.github.crazysmc.backports.BackportsClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.Arrays;

@Mixin(GameOptions.class)
public abstract class GameOptionsMixin
{
  @Shadow
  public KeyBinding[] keyBindings;

  @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V",
          at = @At(value = "FIELD",
                   target = "Lnet/minecraft/client/options/GameOptions;keyBindings:[Lnet/minecraft/client/options/KeyBinding;",
                   opcode = Opcodes.PUTFIELD,
                   shift = At.Shift.AFTER))
  public void init(Minecraft minecraft, File dir, CallbackInfo ci)
  {
    KeyBinding[] keyBindings = Arrays.copyOf(this.keyBindings, this.keyBindings.length + 1);
    keyBindings[this.keyBindings.length] = BackportsClient.perspectiveKey;
    this.keyBindings = keyBindings;
  }
}
