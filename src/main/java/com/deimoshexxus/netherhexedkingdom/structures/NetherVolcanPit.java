package com.deimoshexxus.netherhexedkingdom.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;

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
            new MobSpawnInfo.Spawners(ModEntities.VOLCAN_DAEMON_ENTITY.get(), 3, 0, 1)
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

            int netherGenDepth = 127;
            int netherSeaLevel = 32;
            int heightLimit = 90;
            
            //int netherSeaLevel = chunkGenerator.getSeaLevel();  //overworld sea level value 63
            int y = netherSeaLevel + this.random.nextInt(netherGenDepth - 2 - netherSeaLevel);
            
            BlockPos blockpos = new BlockPos(x, y, z);

            IBlockReader blockReader = chunkGenerator.getBaseColumn(blockpos.getX(), blockpos.getZ());

            for(BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z); y > netherSeaLevel + 40 + this.random.nextInt(netherGenDepth - 36 - netherSeaLevel); --y) {

            	//BlockPos basaltblockpos = (blockpos$mutable.getX() + 32, blockpos$mutable.getY(),blockpos$mutable.getZ() + 32);
            	BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
                blockpos$mutable.move(Direction.DOWN);
                BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable);
                
                if (y < netherGenDepth - netherSeaLevel - 36) //gen depth in 256 (overworld) nether only 127
                {
                	continue;
                }
                if (y > heightLimit)
                {
            		continue;
                }
//                BlockState basaltblockstate = blockReader.getBlockState(basaltblockpos);
//                if (basaltblockstate.is(Blocks.BASALT) && (blockstate.is(Blocks.BASALT)))
//        		{
//                	continue;
//        		}

//                if (this.getBoundingBox().intersects(getBoundingBox()))
//                {
//                	break;
//                }
                //|| blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP)
//                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.BASALT) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) {
//                    break;
//                }
//                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.SOUL_SAND) )) {
//                   break;
//                }
                
                //
                
                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.BASALT) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) {
                    break;
                }
            }
            
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