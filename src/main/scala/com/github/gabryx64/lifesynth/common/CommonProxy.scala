package com.github.gabryx64.lifesynth.common

import com.github.gabryx64.lifesynth.common.blocks.Blocks
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.{
  FMLInitializationEvent,
  FMLPostInitializationEvent,
  FMLPreInitializationEvent
}
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod.EventBusSubscriber
class CommonProxy {
  def preInit(e: FMLPreInitializationEvent): Unit = {
    Config.init(e)
  }

  def init(e: FMLInitializationEvent): Unit = {}

  def postInit(e: FMLPostInitializationEvent): Unit = {}
}

object CommonProxy {
  @SubscribeEvent def registerBlocks(
    event: RegistryEvent.Register[Block]
  ): Unit = {
    Blocks.initBlocks(event.getRegistry)
  }

  @SubscribeEvent def registerItems(
    event: RegistryEvent.Register[Item]
  ): Unit = {
    Blocks.initItemBlocks(event.getRegistry)
  }
}
