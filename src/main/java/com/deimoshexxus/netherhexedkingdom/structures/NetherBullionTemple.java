package com.deimoshexxus.netherhexedkingdom.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
import com.deimoshexxus.netherhexedkingdom.init.ModEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
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

import java.util.List;

public class NetherBullionTemple extends Structure<NoFeatureConfig> {
    public NetherBullionTemple(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return NetherBullionTemple.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }


    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
            new MobSpawnInfo.Spawners(EntityType.WITHER_SKELETON, 100, 1, 6),
            new MobSpawnInfo.Spawners(EntityType.BLAZE, 100, 1, 6),
            new MobSpawnInfo.Spawners(ModEntities.HEXAN_GUARD_MELEE_ENTITY.get(), 100, 3, 9)
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

        return topBlock.getFluidState().isEmpty();// && landHeight > 70;
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

            for(BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z); y > sl + 40 + this.random.nextInt(chunkGenerator.getGenDepth() - 34 - sl); --y) {

            	BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
                blockpos$mutable.move(Direction.DOWN);
                BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable);
                if (y > chunkGenerator.getGenDepth() - sl - 32)
                {
                	continue;
                }
                if (y < sl + 40)
                {
            		continue;
                }
//                if (y < chunkGenerator.getGenDepth() - sl - 52)
//                {
//            		continue;
//                }
                if (this.getBoundingBox().intersects(getBoundingBox()))
                {
                	break;
                }
                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.SOUL_SAND) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) {
                    break;
                }
//                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.SOUL_SAND) )) {
//                   break;
//                }
                //|| blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP)
             }
            
            JigsawManager.addPieces(
                    dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)

                            .get(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_bullion_temple/start_pool")),
                            10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManagerIn,
                    new BlockPos(x, y, z),
                    this.pieces,
                    this.random,
                    false,
                    false);

            this.pieces.forEach(piece -> piece.move(0, 1, 0));
            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= 1);
            this.calculateBoundingBox();

            NetherHexedKingdomMain.LOGGER.log(Level.DEBUG, "Bullion Temple at " +
                            this.pieces.get(0).getBoundingBox().x0 + " " +
                            this.pieces.get(0).getBoundingBox().y0 + " " +
                            this.pieces.get(0).getBoundingBox().z0);
        }
    }
}