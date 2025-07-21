package com.github.gabryx64.lifesynth.common

import com.github.gabryx64.lifesynth.{ParamLazy, Tags}
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

import java.io.File

object Config {
  lazy val (cfg) = ParamLazy((e: FMLPreInitializationEvent) => {
    val cfg = new Configuration(new File(e.getModConfigurationDirectory.getPath, s"${Tags.MOD_ID}.cfg"))
    cfg.load()

    if (cfg.hasChanged) {
      cfg.save()
    }
    (cfg)
  })

  def init(e: FMLPreInitializationEvent): Unit = {
    ParamLazy.init(cfg, e)


  }
}
