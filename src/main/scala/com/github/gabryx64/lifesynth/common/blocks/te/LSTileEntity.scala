package com.github.gabryx64.lifesynth.common.blocks.te
import com.cleanroommc.modularui.api.IGuiHolder
import com.cleanroommc.modularui.drawable.GuiTextures
import com.cleanroommc.modularui.factory.PosGuiData
import com.cleanroommc.modularui.screen.{ModularPanel, UISettings}
import com.cleanroommc.modularui.value.sync.{DoubleSyncValue, PanelSyncManager}
import com.cleanroommc.modularui.widgets.ProgressWidget
import com.github.gabryx64.lifesynth.LifeSynthMod
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ITickable
import net.minecraftforge.fluids.capability.{IFluidHandler, IFluidTankProperties}
import net.minecraftforge.fluids.{Fluid, FluidStack, FluidTank}

class LSTileEntity
  extends TileEntity
     with ITickable
     with IFluidHandler
     with IGuiHolder[PosGuiData] {

  val tank = new FluidTank(Fluid.BUCKET_VOLUME * 16)

  override def readFromNBT(compound: NBTTagCompound): Unit = {
    super.readFromNBT(compound)
    tank.readFromNBT(compound)
  }

  override def writeToNBT(compound: NBTTagCompound): NBTTagCompound = {
    super.writeToNBT(compound)
    tank.writeToNBT(compound)
    compound
  }

  override def buildUI(
    data: PosGuiData,
    syncManager: PanelSyncManager,
    settings: UISettings
  ): ModularPanel = {
    val panel = ModularPanel.defaultPanel("lifesynthesizer")
    panel
      .bindPlayerInventory()
      .child(
        new ProgressWidget()
          .value(new DoubleSyncValue(
            () => tank.getFluidAmount.asInstanceOf[Double] / tank.getCapacity.asInstanceOf[Double],
            { value: Double =>
              LifeSynthMod.log.info(value * tank.getCapacity)
            }
          ))
          .size(20)
          .leftRel(0.25f)
          .rightRel(0.25f)
          .topRelAnchor(0.25f, 0.5f)
          .texture(GuiTextures.SLOT_FLUID, 20)
      )
    panel
  }

  override def update(): Unit = {}

  override def getTankProperties: Array[IFluidTankProperties] =
    tank.getTankProperties
  override def fill(resource: FluidStack, doFill: Boolean): Int =
    tank.fill(resource, doFill)
  override def drain(resource: FluidStack, doDrain: Boolean): FluidStack =
    tank.drain(resource, doDrain)
  override def drain(maxDrain: Int, doDrain: Boolean): FluidStack =
    tank.drain(maxDrain, doDrain)
}
