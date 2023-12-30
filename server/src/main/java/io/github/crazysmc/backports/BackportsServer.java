package io.github.crazysmc.backports;

import net.ornithemc.osl.entrypoints.api.server.ServerModInitializer;

public class BackportsServer implements ServerModInitializer
{
  @Override
  public void initServer()
  {
    Backports.LOGGER.info("Initializing Backports server side");
  }
}
