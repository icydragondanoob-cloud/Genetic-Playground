package net.mcreator.geneticplayground.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.procedures.WarningSignOnBlockRightClickedProcedure;

public class BiohazardSignBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final DirectionProperty FACING = DirectionalBlock.FACING;

	public BiohazardSignBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 1, 0, 15, 15, 1);
				case NORTH -> box(1, 1, 15, 15, 15, 16);
				case EAST -> box(0, 1, 1, 1, 15, 15);
				case WEST -> box(15, 1, 1, 16, 15, 15);
				case UP -> box(1, 0, 1, 15, 1, 15);
				case DOWN -> box(1, 15, 1, 15, 16, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 1, 0, 15, 15, 1);
				case NORTH -> box(1, 1, 15, 15, 15, 16);
				case EAST -> box(0, 1, 1, 1, 15, 15);
				case WEST -> box(15, 1, 1, 16, 15, 15);
				case UP -> box(1, 0, 1, 15, 1, 15);
				case DOWN -> box(1, 15, 1, 15, 16, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 1, 0, 15, 15, 1);
				case NORTH -> box(1, 1, 15, 15, 15, 16);
				case EAST -> box(0, 1, 1, 1, 15, 15);
				case WEST -> box(15, 1, 1, 16, 15, 15);
				case UP -> box(1, 0, 1, 15, 1, 15);
				case DOWN -> box(1, 15, 1, 15, 16, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 1, 0, 15, 15, 1);
				case NORTH -> box(1, 1, 15, 15, 15, 16);
				case EAST -> box(0, 1, 1, 1, 15, 15);
				case WEST -> box(15, 1, 1, 16, 15, 15);
				case UP -> box(1, 0, 1, 15, 1, 15);
				case DOWN -> box(1, 15, 1, 15, 16, 15);
			};
		}
		return switch (state.getValue(FACING)) {
			default -> box(1, 1, 0, 15, 15, 1);
			case NORTH -> box(1, 1, 15, 15, 15, 16);
			case EAST -> box(0, 1, 1, 1, 15, 15);
			case WEST -> box(15, 1, 1, 16, 15, 15);
			case UP -> box(1, 0, 1, 15, 1, 15);
			case DOWN -> box(1, 15, 1, 15, 16, 15);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		WarningSignOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate);
		return InteractionResult.SUCCESS;
	}
}