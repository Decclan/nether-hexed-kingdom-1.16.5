package com.deimoshexxus.netherhexedkingdom.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;

//import net.minecraft.world.gen.feature.structure.NetherFossilStructure;
//import net.minecraft.world.gen.feature.structure.NetherFossilStructures;

import java.util.List;

public class NetherVolcanPit extends Structure<NoFeatureConfig> {
    public NetherVolcanPit(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return NetherVolcanPit.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }


    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
//            new MobSpawnInfo.Spawners(ModEntities.PIGLIN_BESERKER_ENTITY.get(), 3, 0, 1)
    );
    
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
    }

    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);

        int landHeight = chunkGenerator.getFirstOccupiedHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());

        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));

        return topBlock.getFluidState().isEmpty(); // && landHeight < 80;
    }

    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            int sl = chunkGenerator.getSeaLevel();
            int y = sl + this.random.nextInt(chunkGenerator.getGenDepth() - 2 - sl);

            BlockPos blockpos = new BlockPos(x, y, z);

            IBlockReader blockReader = chunkGenerator.getBaseColumn(blockpos.getX(), blockpos.getZ());

            for(BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z); y > sl; --y) {

            	BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
                blockpos$mutable.move(Direction.DOWN);
                BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable);
                //BlockState northbasalt = blockReader.getBlockState(blockpos$mutable);
                //blockpos$mutable.move(Direction.NORTH);
                //BlockState southbasalt = blockReader.getBlockState(blockpos$mutable);
                //blockpos$mutable.move(Direction.SOUTH);
                //BlockState eastbasalt = blockReader.getBlockState(blockpos$mutable);
                //blockpos$mutable.move(Direction.EAST);
                //BlockState westbasalt = blockReader.getBlockState(blockpos$mutable);
                //blockpos$mutable.move(Direction.WEST);
                
//                if (this.getBoundingBox().intersects(getBoundingBox()))
//                {
//                	break;
//                }
//                if (!blockstate1.is(Blocks.BASALT))
//                {
//                    continue;
//                }
                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.BASALT) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) { // && (blockstate1.is(Blocks.BASALT))
                   break;
                }
             }  
//                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.BASALT) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) {
//                    break;
//                }
//            }
            if (y > 60 && y < 90)
            {
	            JigsawManager.addPieces(
	                    dynamicRegistryManager,
	                    new VillageConfig(() -> dynamicRegistryManager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
	
	                            .get(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_volcan_pit/start_pool")),
	                            10),
	                    AbstractVillagePiece::new,
	                    chunkGenerator,
	                    templateManagerIn,
	                    new BlockPos(x, y, z),
	                    this.pieces,
	                    this.random,
	                    false,
	                    false);
	
	            this.pieces.forEach(piece -> piece.move(0, -1, 0));
	            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= 1);
	            this.calculateBoundingBox();
	
	            NetherHexedKingdomMain.LOGGER.log(Level.DEBUG, "Volcan Pit at " +
	                            this.pieces.get(0).getBoundingBox().x0 + " " +
	                            this.pieces.get(0).getBoundingBox().y0 + " " +
	                            this.pieces.get(0).getBoundingBox().z0);
            }
        }
    }
}