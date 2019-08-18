package amidst.mojangapi.world.icon.producer;

import amidst.documentation.ThreadSafe;
import amidst.logging.AmidstLogger;
import amidst.mojangapi.file.Version;
import amidst.mojangapi.minecraftinterface.RecognisedVersion;
import amidst.mojangapi.world.Dimension;
import amidst.mojangapi.world.WorldSalts;
import amidst.mojangapi.world.biome.Biome;
import amidst.mojangapi.world.coordinates.CoordinatesInWorld;
import amidst.mojangapi.world.icon.WorldIcon;
import amidst.mojangapi.world.icon.locationchecker.StructureBiomeLocationChecker;
import amidst.mojangapi.world.icon.locationchecker.WoodlandMansionLocationChecker;
import amidst.mojangapi.world.icon.type.DefaultWorldIconTypes;
import amidst.mojangapi.world.oracle.BiomeDataOracle;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@ThreadSafe
public class MansionProducer extends CachedWorldIconProducer {
    private static final int REGION_SIZE = 80;
    private static final int CHUNK_RANGE = 60;

    private final long seed;
    private final CoordinatesInWorld pos;
    private final WorldSalts worldSalts;
    private final RecognisedVersion version;
    private final StructureBiomeLocationChecker biomeLocationChecker;

    public MansionProducer(long seed, BiomeDataOracle biomeDataOracle, List<Biome> validBiomes, CoordinatesInWorld pos, WorldSalts worldSalts, RecognisedVersion version) {
        this.seed = seed;
        this.pos = pos;
        this.worldSalts = worldSalts;
        this.version = version;
        this.biomeLocationChecker = new StructureBiomeLocationChecker(biomeDataOracle, 32, validBiomes);

    }

    @Override
    protected List<WorldIcon> doCreateCache() {
        List<WorldIcon> result = new LinkedList<>();
        long x = pos.getX() / 80 / 16;
        long y = pos.getY() / 80 / 16;
        int RING_NUMBER = 1;
        int structureFound = 0;
        while (structureFound < getTotalStructureCount()) {
            for (int base = -RING_NUMBER; base <= RING_NUMBER + 1; base++) {
                Pos top = isValidMansion(x + RING_NUMBER, y + base, seed);
                if (top.success) {
                    result.add(createWorldIcon(new CoordinatesInWorld(top.x, top.z)));
                    structureFound++;
                }
                Pos bottom = isValidMansion(x - RING_NUMBER, y + base, seed);
                if (bottom.success) {
                    result.add(createWorldIcon(new CoordinatesInWorld(bottom.x, bottom.z)));
                    structureFound++;
                }
            }
            for (int side = -RING_NUMBER + 1; side < RING_NUMBER; side++) {
                Pos right = isValidMansion(x + side, y + RING_NUMBER, seed);
                if (right.success) {
                    result.add(createWorldIcon(new CoordinatesInWorld(right.x, right.z)));
                    structureFound++;
                }
                Pos left = isValidMansion(x + side, y - RING_NUMBER, seed);
                if (left.success) {
                    result.add(createWorldIcon(new CoordinatesInWorld(left.x, left.z)));
                    structureFound++;
                }
            }
            RING_NUMBER++;
        }
        return result;
    }

    static class Pos {
        int x;
        int z;
        boolean success;
    }

    private Pos isValidMansion(long regionX, long regionZ, long seed) {
        Pos pos = new Pos();
        seed = regionX * 341873128712L + regionZ * 132897987541L + seed + worldSalts.getSeedForStructure_WoodlandMansion().getValue(version);
        seed = (seed ^ 0x5deece66dL) & ((1L << 48) - 1);

        seed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL;
        pos.x = (int) ((seed >> 17) % CHUNK_RANGE);
        seed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL;
        pos.x += (seed >> 17) % CHUNK_RANGE;

        seed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL;
        pos.z = (int) ((seed >> 17) % CHUNK_RANGE);
        seed = (seed * 0x5deece66dL + 0xbL) & 0xffffffffffffL;
        pos.z += (seed >> 17) % CHUNK_RANGE;

        pos.x = (int) (regionX * REGION_SIZE + (pos.x >> 1));
        pos.z = (int) (regionZ * REGION_SIZE + (pos.z >> 1));
        pos.success = biomeLocationChecker.isValidLocation(pos.x, pos.z);
        pos.x = pos.x * 16 + 8;
        pos.z = pos.z * 16 + 8;
        return pos;
    }


    private WorldIcon createWorldIcon(CoordinatesInWorld coordinates) {
        return new WorldIcon(
                coordinates,
                DefaultWorldIconTypes.WOODLAND_MANSION.getLabel(),
                DefaultWorldIconTypes.WOODLAND_MANSION.getImage(),
                Dimension.OVERWORLD,
                false);
    }

    private int getTotalStructureCount() {
        return 10;
    }

}
