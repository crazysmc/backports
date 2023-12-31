package io.github.crazysmc.backports;

import net.minecraft.client.options.KeyBinding;
import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;

public class BackportsClient implements ClientModInitializer
{
  public static KeyBinding perspectiveKey = new KeyBinding("key.togglePerspective", 63);

  @Override
  public void initClient()
  {
    Backports.LOGGER.info("Initializing Backports client side");
  }
}
