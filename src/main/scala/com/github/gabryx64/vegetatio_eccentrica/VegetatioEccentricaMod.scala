package com.github.gabryx65.vegetatio_eccentrica

import com.github.gabryx64.vegetatio_eccentrica.{ParamLazy, Tags}
import com.github.gabryx64.vegetatio_eccentrica.common.CommonProxy
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import org.apache.logging.log4j.{LogManager, Logger}

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, modLanguage = "scala", useMetadata = true)
object VegetatioEccentricaMod {
  final val log: Logger = LogManager.getLogger(Tags.MOD_NAME)

  @Mod.Instance
  var inst: VegetatioEccentricaMod.type = this

  @SidedProxy(
    clientSide = "com.github.gabryx64.vegetatio_eccentrica.client.ClientProxy",
    serverSide = "com.github.gabryx64.vegetatio_eccentrica.server.ServerProxy"
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
