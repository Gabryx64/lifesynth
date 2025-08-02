package com.github.gabryx64.lifesynth.common.blocks
import com.github.gabryx64.lifesynth.Tags
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.registries.IForgeRegistry

object Blocks {
  lazy final val lifeSynthesizer = new BlockLifeSynthesizer
  lazy final val blocks = Array(
    lifeSynthesizer
  )

  def initBlocks(registry: IForgeRegistry[Block]): Unit = blocks.foreach {
    block =>
      registry.register(block)

      block match {
        case b: TileEntityBlock[_] =>
          GameRegistry.registerTileEntity(
            b.teClass,
            s"${Tags.MOD_ID}_${b.getRegistryName.getPath}"
          )
        case _ =>
      }
  }

  def initModels(): Unit = blocks.foreach {
    case b: TileEntityBlock[_] =>
      b.initModel()
    case _ =>
  }

  def initItemBlocks(registry: IForgeRegistry[Item]): Unit =
    blocks.foreach { block =>
      registry.register(
        new ItemBlock(block)
          .setRegistryName(block.getRegistryName)
      )
    }
}
