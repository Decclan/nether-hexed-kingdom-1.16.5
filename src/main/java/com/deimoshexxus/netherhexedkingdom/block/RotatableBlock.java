package com.deimoshexxus.netherhexedkingdom.block;

import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;


public class RotatableBlock extends Block
{
	
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	protected static final VoxelShape AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D);

	public RotatableBlock(Properties p_i48339_1_) {
		super(p_i48339_1_);
		this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
	}
	
   public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
	      return AABB;
	   }
	
   public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
	      return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
	   }
   
   public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
	      return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
	   }
////
//   @SuppressWarnings("deprecation")
//public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
//      return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
//   }

   protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
      p_206840_1_.add(FACING);
   }

	public boolean useShapeForLightOcclusion() 
	{
	    return true;
	}
	
}

