package com.github.gabryx64.vegetatio_eccentrica.client

import com.github.gabryx64.vegetatio_eccentrica.common.CommonProxy
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side

@Mod.EventBusSubscriber(Array(Side.CLIENT))
class ClientProxy extends CommonProxy {
  override def preInit(e: FMLPreInitializationEvent): Unit = {
    super.preInit(e)
  }
}

object ClientProxy {
  @SubscribeEvent def registerModels(event: ModelRegistryEvent): Unit = {
  }
}
