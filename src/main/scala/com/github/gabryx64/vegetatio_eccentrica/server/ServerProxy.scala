package com.github.gabryx64.vegetatio_eccentrica.server

import com.github.gabryx64.vegetatio_eccentrica.common.CommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.relauncher.Side

@Mod.EventBusSubscriber(Array(Side.SERVER))
class ServerProxy extends CommonProxy {}