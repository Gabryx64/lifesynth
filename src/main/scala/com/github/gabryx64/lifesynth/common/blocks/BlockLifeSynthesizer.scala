package com.github.gabryx64.lifesynth.common.blocks
import com.cleanroommc.modularui.factory.GuiFactories
import com.github.gabryx64.lifesynth.Tags
import com.github.gabryx64.lifesynth.common.blocks.te.LSTileEntity
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyDirection
import net.minecraft.block.state.{BlockStateContainer, IBlockState}
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{EnumFacing, EnumHand}
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.relauncher.{Side, SideOnly}

class BlockLifeSynthesizer
  extends TileEntityBlock[LSTileEntity](Material.IRON) {
  setRegistryName("lifesynthesizer")
  setTranslationKey(s"${Tags.MOD_ID}.lifesynthesizer")

  final lazy val FACING =
    PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL)

  @SideOnly(Side.CLIENT) def initModel(): Unit =
    ModelLoader.setCustomModelResourceLocation(
      Item.getItemFromBlock(this),
      0,
      new ModelResourceLocation(getRegistryName, "inventory")
    )

  override def createNewTileEntity(world: World, meta: Int): TileEntity =
    new LSTileEntity

  override def onBlockPlacedBy(
    world: World,
    pos: BlockPos,
    state: IBlockState,
    placer: EntityLivingBase,
    stack: ItemStack
  ): Unit =
    world.setBlockState(
      pos,
      state.withProperty(FACING, placer.getHorizontalFacing.getOpposite),
      2
    )

  override def onBlockActivated(
    worldIn: World,
    pos: BlockPos,
    state: IBlockState,
    playerIn: EntityPlayer,
    hand: EnumHand,
    facing: EnumFacing,
    hitX: Float,
    hitY: Float,
    hitZ: Float
  ): Boolean = {
    if (!worldIn.isRemote) {
      GuiFactories.tileEntity().open(playerIn, pos)
    }

    true
  }

  override def getStateFromMeta(meta: Int): IBlockState =
    getDefaultState.withProperty(FACING, EnumFacing.byIndex((meta & 3) + 2))
  override def getMetaFromState(state: IBlockState): Int =
    state.getValue(FACING).getIndex - 2

  override protected def createBlockState =
    new BlockStateContainer(this, FACING)
}
