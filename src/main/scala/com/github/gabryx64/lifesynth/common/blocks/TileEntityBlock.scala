package com.github.gabryx64.lifesynth.common.blocks

import net.minecraft.block.{Block, ITileEntityProvider}
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

import scala.reflect.ClassTag

abstract class TileEntityBlock[T <: TileEntity](mat: Material) extends Block(mat) with ITileEntityProvider {
  def teClass(implicit ct: ClassTag[T]): Class[TileEntity] = ct.runtimeClass.asInstanceOf[Class[TileEntity]]

  @SideOnly(Side.CLIENT) def initModel(): Unit
}
