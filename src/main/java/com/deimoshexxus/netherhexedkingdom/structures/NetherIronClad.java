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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;

import java.util.List;

public class NetherIronClad extends Structure<NoFeatureConfig> {
    public NetherIronClad(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return NetherIronClad.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.UNDERGROUND_DECORATION;
    }


    private static final List<MobSpawnInfo.Spawners> STRUCTURE_MONSTERS = ImmutableList.of(
            new MobSpawnInfo.Spawners(EntityType.BLAZE, 70, 5, 12),
            new MobSpawnInfo.Spawners(ModEntities.HEXAN_GUARD_RANGED_ENTITY.get(), 70, 5, 12)
    );
    
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return STRUCTURE_MONSTERS;
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
            int y = sl - 3;
            
            this.boundingBox = MutableBoundingBox.getUnknownBox();
            
            BlockPos blockpos = new BlockPos(x, y, z);

            IBlockReader blockReader = chunkGenerator.getBaseColumn(blockpos.getX(), blockpos.getZ());

            for(BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z); y > sl; --y) // y always less than sea level
            {
            	BlockPos.Mutable airblockpos = new BlockPos.Mutable(x+6, y+4, z+6);
            	//BlockPos.Mutable lavablockpos = new BlockPos.Mutable(x+6, y-4, z+6);
            	//BlockPos.Mutable blockpos$mutableeast = new BlockPos.Mutable(x+14, y+4, z+14);
                BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
                blockpos$mutable.move(Direction.DOWN);
                BlockState blockstatedown = blockReader.getBlockState(blockpos$mutable);
                
                
                if (this.getBoundingBox().intersects(getBoundingBox()))
                {
                	break;
                }
                if (blockstate.is(Blocks.AIR) && (blockstatedown.is(Blocks.SOUL_SAND) || blockstatedown.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP))) 
                {
                   break;
                }
//                if (blockstatedown.is(Blocks.LAVA))
//        		{
//                	return;
//        		}
                //BlockState lavablockstate= blockReader.getBlockState(lavablockpos); //doesnt do anything
                BlockState airblockstate = blockReader.getBlockState(airblockpos);
                for(int yaircheck = y + 32; y < yaircheck; --y) //cancels out prior for loop --y
                {
                	if (airblockstate.is(Blocks.AIR) && (blockstatedown.is(Blocks.LAVA))) // && (lavablockstate.is(Blocks.LAVA))
                	{
                		return;
                	}
                }break;
                
                
//                if (airblockstate.is(Blocks.AIR)) 
//                {
//                	continue;
//                }
                
//                BlockState blockstateeast = blockReader.getBlockState(blockpos$mutableeast);
//                if (blockstateeast.is(Blocks.AIR))
//        		{
//                	continue;
//        		}else
//        		{
//        			break;
//        		}
             }
            JigsawManager.addPieces(
                    dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)

                            .get(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, "hexed_iron_clad/start_pool")),
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

            NetherHexedKingdomMain.LOGGER.log(Level.DEBUG, "Iron Clad at " +
                            this.pieces.get(0).getBoundingBox().x0 + " " +
                            this.pieces.get(0).getBoundingBox().y0 + " " +
                            this.pieces.get(0).getBoundingBox().z0);
        }
    }
}