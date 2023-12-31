package io.github.crazysmc.backports.mixin;

import io.github.crazysmc.backports.Backports;
import net.minecraft.locale.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.Properties;

@Mixin(LanguageManager.class)
public abstract class LanguageManagerMixin
{
  @Shadow
  private Properties translations;

  @Inject(method = "<init>",
          at = @At(value = "INVOKE", target = "Ljava/util/Properties;load(Ljava/io/InputStream;)V", ordinal = 0))
  private void init(CallbackInfo ci)
  {
    try
    {
      translations.load(LanguageManager.class.getResourceAsStream("/backports/lang/en_US.lang"));
    }
    catch (IOException e)
    {
      Backports.LOGGER.error("Could not read from /backports/lang/en_US.lang", e);
    }
  }
}
