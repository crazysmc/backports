package io.github.crazysmc.backports;

import net.ornithemc.osl.entrypoints.api.client.ClientModInitializer;

public class BackportsClient implements ClientModInitializer
{
  @Override
  public void initClient()
  {
    Backports.LOGGER.info("Initializing Backports client side");
  }
}
