package amidst.mojangapi.world.icon.locationchecker;

import java.util.List;
import java.util.Random;

import amidst.documentation.ThreadSafe;
import amidst.mojangapi.world.biome.Biome;
import amidst.mojangapi.world.oracle.BiomeDataOracle;

@ThreadSafe
public class PillagerOutpostLocationChecker extends AllValidLocationChecker {
    private static final long MAGIC_NUMBER_FOR_SEED_1 = 341873128712L;
    private static final long MAGIC_NUMBER_FOR_SEED_2 = 132897987541L;
    private static final long MAGIC_NUMBER_FOR_SEED_3 = 165745296L;
    private static final byte MAX_DISTANCE_BETWEEN_SCATTERED_FEATURES = 32;
    private static final byte MIN_DISTANCE_BETWEEN_SCATTERED_FEATURES = 8;
    private static final boolean USE_TWO_VALUES_FOR_UPDATE = false;
    private static final int STRUCTURE_SIZE = 0;


    public PillagerOutpostLocationChecker(
            long seed, BiomeDataOracle biomeDataOracle, List<Biome> validBiomesForStructure, long structureSalt) {
        super(
                new StructureAlgorithm(
                        seed,
                        MAGIC_NUMBER_FOR_SEED_1,
                        MAGIC_NUMBER_FOR_SEED_2,
                        structureSalt,
                        MAX_DISTANCE_BETWEEN_SCATTERED_FEATURES,
                        MIN_DISTANCE_BETWEEN_SCATTERED_FEATURES,
                        USE_TWO_VALUES_FOR_UPDATE),
                new PillagerOutpostAlgorithm(seed),
                new StructureBiomeLocationChecker(biomeDataOracle, STRUCTURE_SIZE, validBiomesForStructure)
        );
    }

    private static class PillagerOutpostAlgorithm implements LocationChecker {
        private final long seed;

        public PillagerOutpostAlgorithm(long seed) {
            this.seed = seed;
        }

        @Override
        public boolean isValidLocation(int x, int y) {
            Random random = new Random((x >> 4) ^ ((y >> 4) << 4) ^ seed);
            random.nextInt();
            return random.nextInt(5) == 0;
        }
    }
}
