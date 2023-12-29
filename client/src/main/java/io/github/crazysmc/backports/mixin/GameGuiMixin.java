package io.github.crazysmc.backports.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GameGui;
import net.minecraft.client.gui.GuiElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameGui.class)
public abstract class GameGuiMixin extends GuiElement
{
  @Shadow
  private Minecraft minecraft;

  @Inject(method = "render",
          at = @At(value = "INVOKE",
                   target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V",
                   ordinal = 4,
                   shift = At.Shift.AFTER))
  public void render(float tickDelta, boolean screenOpen, int mouseX, int mouseY, CallbackInfo ci)
  {
    this.drawString(minecraft.textRenderer, "Y: " + (minecraft.player.y - minecraft.player.eyeHeight), 2, 88, 0xe0e0e0);
  }
}
