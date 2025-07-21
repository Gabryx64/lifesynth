package com.github.gabryx64.lifesynth

import com.github.gabryx64.lifesynth.{ParamLazy, Tags}
import com.github.gabryx64.lifesynth.common.CommonProxy
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import org.apache.logging.log4j.{LogManager, Logger}

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, modLanguage = "scala", useMetadata = true)
object LifeSynthMod {
  final val log: Logger = LogManager.getLogger(Tags.MOD_NAME)

  @Mod.Instance
  var inst: LifeSynthMod.type = this

  @SidedProxy(
    clientSide = "com.github.gabryx64.lifesynth.client.ClientProxy",
    serverSide = "com.github.gabryx64.lifesynth.server.ServerProxy"
  )
  var proxy: CommonProxy = _

  @Mod.EventHandler def preInit(e: FMLPreInitializationEvent): Unit = {
    proxy.preInit(e)
  }

  @Mod.EventHandler def init(e: FMLInitializationEvent): Unit = {
    proxy.init(e)
  }

  @Mod.EventHandler def postInit(e: FMLPostInitializationEvent): Unit = {
    proxy.postInit(e)
  }
}
