package com.github.gabryx64.lifesynth.server

import com.github.gabryx64.lifesynth.common.CommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.relauncher.Side

@Mod.EventBusSubscriber(Array(Side.SERVER))
class ServerProxy extends CommonProxy {}
