package amidst.mojangapi.world.oracle;

import java.util.Random;

import amidst.documentation.Immutable;

@Immutable
public class SlimeChunkOracle {
	private final long seed;

	public SlimeChunkOracle(long seed) {
		this.seed = seed;
	}

	public boolean isSlimeChunk(long chunkX, long chunkY) {
		Random random = new Random(getSeed((int) chunkX, (int) chunkY));
		return isSlimeChunk(random);
	}

	/**
	 * Make sure this uses integers for the parameters chunkX and chunkY and
	 * long for the seed. This ensure the overflow works as in Minecraft.
	 */
	private long getSeed(int chunkX, int chunkY) {
		return seed + chunkX * chunkX * 0x4c1906 + chunkX * 0x5ac0db + chunkY * chunkY * 0x4307a7L + chunkY * 0x5f24f
				^ 987234911;
	}

	private boolean isSlimeChunk(Random random) {
		return random.nextInt(10) == 0;
	}
}
