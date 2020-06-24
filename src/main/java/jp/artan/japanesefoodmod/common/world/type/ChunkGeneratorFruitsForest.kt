package jp.artan.japanesefoodmod.common.world.type

import net.minecraft.entity.EnumCreatureType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.gen.IChunkGenerator

class ChunkGeneratorFruitsForest : IChunkGenerator {
    override fun generateChunk(x: Int, z: Int): Chunk? {
        return null
    }

    override fun populate(x: Int, z: Int) {

    }

    override fun generateStructures(chunkIn: Chunk, x: Int, z: Int): Boolean {
        return false
    }

    override fun getPossibleCreatures(creatureType: EnumCreatureType, pos: BlockPos): List<Biome.SpawnListEntry>? {
        return null
    }

    override fun getNearestStructurePos(worldIn: World, structureName: String, position: BlockPos, findUnexplored: Boolean): BlockPos? {
        return null
    }

    override fun recreateStructures(chunkIn: Chunk, x: Int, z: Int) {

    }

    override fun isInsideStructure(worldIn: World, structureName: String, pos: BlockPos): Boolean {
        return false
    }
}
