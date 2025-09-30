package net.mcreator.geneticplayground.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.geneticplayground.procedures.GoldCableOnTickUpdateProcedure;
import net.mcreator.geneticplayground.procedures.GoldCableNeighbourBlockChangesProcedure;
import net.mcreator.geneticplayground.block.entity.GoldCableBlockEntity;

public class GoldCableBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 16);
	public static final DirectionProperty FACING = DirectionalBlock.FACING;

	public GoldCableBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				if (s.getValue(BLOCKSTATE) == 10)
					return 0;
				if (s.getValue(BLOCKSTATE) == 11)
					return 0;
				if (s.getValue(BLOCKSTATE) == 12)
					return 0;
				if (s.getValue(BLOCKSTATE) == 13)
					return 0;
				if (s.getValue(BLOCKSTATE) == 14)
					return 0;
				if (s.getValue(BLOCKSTATE) == 15)
					return 0;
				if (s.getValue(BLOCKSTATE) == 16)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).dynamicShape());
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
				default -> box(6, 6, 6, 10, 10, 10);
				case NORTH -> box(6, 6, 6, 10, 10, 10);
				case EAST -> box(6, 6, 6, 10, 10, 10);
				case WEST -> box(6, 6, 6, 10, 10, 10);
				case UP -> box(6, 6, 6, 10, 10, 10);
				case DOWN -> box(6, 6, 6, 10, 10, 10);
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 8), box(6, 6, 8, 10, 10, 16));
				case NORTH -> Shapes.or(box(6, 6, 8, 10, 10, 16), box(6, 6, 0, 10, 10, 8));
				case EAST -> Shapes.or(box(0, 6, 6, 8, 10, 10), box(8, 6, 6, 16, 10, 10));
				case WEST -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 8, 10), box(6, 8, 6, 10, 16, 10));
				case DOWN -> Shapes.or(box(6, 8, 6, 10, 16, 10), box(6, 0, 6, 10, 8, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(0, 6, 6, 9, 10, 10), box(6, 6, 10, 10, 10, 16), box(9, 6, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(7, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 6, 7, 10, 10));
				case EAST -> Shapes.or(box(6, 6, 7, 10, 10, 16), box(10, 6, 6, 16, 10, 10), box(6, 6, 6, 10, 10, 7));
				case WEST -> Shapes.or(box(6, 6, 0, 10, 10, 9), box(0, 6, 6, 6, 10, 10), box(6, 6, 9, 10, 10, 10));
				case UP -> Shapes.or(box(7, 6, 6, 16, 10, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 6, 7, 10, 10));
				case DOWN -> Shapes.or(box(7, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 6, 7, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(0, 6, 6, 8, 10, 10), box(8, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 6));
				case NORTH -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 6, 10, 10, 10, 16));
				case EAST -> Shapes.or(box(6, 6, 8, 10, 10, 16), box(6, 6, 0, 10, 10, 8), box(0, 6, 6, 6, 10, 10));
				case WEST -> Shapes.or(box(6, 6, 0, 10, 10, 8), box(6, 6, 8, 10, 10, 16), box(10, 6, 6, 16, 10, 10));
				case UP -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 0, 6, 10, 6, 10));
				case DOWN -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 10, 6, 10, 16, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(0, 6, 6, 8, 10, 10), box(8, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16));
				case NORTH -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6));
				case EAST -> Shapes.or(box(6, 6, 8, 10, 10, 16), box(6, 6, 0, 10, 10, 8), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10));
				case WEST -> Shapes.or(box(6, 6, 0, 10, 10, 8), box(6, 6, 8, 10, 10, 16), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10));
				case UP -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 0, 6, 10, 6, 10), box(6, 10, 6, 10, 16, 10));
				case DOWN -> Shapes.or(box(8, 6, 6, 16, 10, 10), box(0, 6, 6, 8, 10, 10), box(6, 10, 6, 10, 16, 10), box(6, 0, 6, 10, 6, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		if (state.getValue(BLOCKSTATE) == 11) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 12) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(6, 10, 6, 10, 16, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(6, 0, 6, 10, 6, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		if (state.getValue(BLOCKSTATE) == 13) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 7, 6, 10, 16, 10), box(6, 6, 6, 10, 7, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 14) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(0, 6, 6, 6, 10, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		if (state.getValue(BLOCKSTATE) == 15) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 7, 6, 10, 19, 10), box(6, 6, 6, 10, 7, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 7, 6, 10, 19, 10), box(6, 6, 6, 10, 7, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(6, 7, 6, 10, 19, 10), box(6, 6, 6, 10, 7, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(6, 7, 6, 10, 19, 10), box(6, 6, 6, 10, 7, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, 7, 10, 10, 19), box(6, 6, 6, 10, 10, 7));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, -3, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 16) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 6, 0, 10, 10, 6), box(10, 6, 6, 16, 10, 10), box(0, 6, 6, 6, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case NORTH -> Shapes.or(box(6, 6, 10, 10, 10, 16), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case EAST -> Shapes.or(box(0, 6, 6, 6, 10, 10), box(6, 6, 0, 10, 10, 6), box(6, 6, 10, 10, 10, 16), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case WEST -> Shapes.or(box(10, 6, 6, 16, 10, 10), box(6, 6, 10, 10, 10, 16), box(6, 6, 0, 10, 10, 6), box(6, 0, 6, 10, 9, 10), box(6, 9, 6, 10, 10, 10));
				case UP -> Shapes.or(box(6, 0, 6, 10, 6, 10), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, 0, 10, 10, 9), box(6, 6, 9, 10, 10, 10));
				case DOWN -> Shapes.or(box(6, 10, 6, 10, 16, 10), box(0, 6, 6, 6, 10, 10), box(10, 6, 6, 16, 10, 10), box(6, 6, 7, 10, 10, 16), box(6, 6, 6, 10, 10, 7));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> box(6, 6, 6, 10, 10, 10);
			case NORTH -> box(6, 6, 6, 10, 10, 10);
			case EAST -> box(6, 6, 6, 10, 10, 10);
			case WEST -> box(6, 6, 6, 10, 10, 10);
			case UP -> box(6, 6, 6, 10, 10, 10);
			case DOWN -> box(6, 6, 6, 10, 10, 10);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
		GoldCableNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		GoldCableNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		GoldCableOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new GoldCableBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof GoldCableBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof GoldCableBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}