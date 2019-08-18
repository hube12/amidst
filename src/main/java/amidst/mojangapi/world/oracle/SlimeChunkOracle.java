package amidst.mojangapi.world.oracle;

import java.util.Random;

import amidst.documentation.Immutable;

@Immutable
public class SlimeChunkOracle {
	private final long seed;
	private final long salt;

	public SlimeChunkOracle(long seed, long salt) {
		this.seed = seed;
		this.salt=salt;
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
				^ salt;
	}

	private boolean isSlimeChunk(Random random) {
		return random.nextInt(10) == 0;
	}
}
