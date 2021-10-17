package com.deimoshexxus.netherhexedkingdom.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;
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

public class NetherWatchTower extends Structure<NoFeatureConfig> {
    public NetherWatchTower(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return NetherWatchTower.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }


    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
            new MobSpawnInfo.Spawners(EntityType.WITHER_SKELETON, 100, 4, 9)
    );
    
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
    }

//    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
//            new MobSpawnInfo.Spawners(EntityType.SHEEP, 30, 10, 15),
//            new MobSpawnInfo.Spawners(EntityType.RABBIT, 100, 1, 2)
//    );
//    @Override
//    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
//        return STRUCTURE_CREATURES;
//    }

    //generates land around base of structure
    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);

        // Grab height of land. Will stop at first non-air block.
        int landHeight = chunkGenerator.getFirstOccupiedHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        // Grabs column of blocks at given position. In overworld, this column will be made of stone, water, and air.
        // In nether, it will be netherrack, lava, and air. End will only be endstone and air. It depends on what block
        // the chunk generator will place for that dimension.
        IBlockReader columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ());

        // Combine the column of blocks with land height and you get the top block itself which you can test.
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.above(landHeight));

        // Now we test to make sure our structure is not spawning on water or other fluids.
        // You can do height check instead too to make it spawn at high elevations.
        return topBlock.getFluidState().isEmpty(); //landHeight > 100;
    }

    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {

            // Turns the chunk coordinates into actual coordinates we can use. (Gets center of that chunk)
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
                if (blockstate.is(Blocks.AIR) && (blockstate1.is(Blocks.SOUL_SAND) || blockstate1.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) {
                   break;
                }
             }
            
            JigsawManager.addPieces(
                    dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)

                            .get(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_watch_tower/start_pool")),
                            10),
                    AbstractVillagePiece::new,
                    chunkGenerator,
                    templateManagerIn,
                    new BlockPos(x, y, z), // Position of the structure. Y value is ignored if last parameter is set to true.
                    this.pieces, // The list that will be populated with the jigsaw pieces after this method.
                    this.random,
                    false, // Special boundary adjustments for villages. It's... hard to explain. Keep this false and make your pieces not be partially intersecting.
                        // Either not intersecting or fully contained will make children pieces spawn just fine. It's easier that way.
                    false);  // Place at heightmap (top land). Set this to false for structure to be place at the passed in blockpos's Y value instead.
                         // Definitely keep this false when placing structures in the nether as otherwise, heightmap placing will put the structure on the Bedrock roof.


            this.pieces.forEach(piece -> piece.move(0, 1, 0));
            this.pieces.forEach(piece -> piece.getBoundingBox().y0 -= 1);
            this.calculateBoundingBox();

            NetherHexedKingdomMain.LOGGER.log(Level.DEBUG, "Watch Tower at " +
                            this.pieces.get(0).getBoundingBox().x0 + " " +
                            this.pieces.get(0).getBoundingBox().y0 + " " +
                            this.pieces.get(0).getBoundingBox().z0);
        }
    }
}