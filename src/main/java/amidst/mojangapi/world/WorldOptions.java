package amidst.mojangapi.world;

import amidst.documentation.Immutable;
import amidst.mojangapi.file.SaveGame;

@Immutable
public class WorldOptions {
    private final WorldSeed worldSeed;
    private final WorldType worldType;
    private final String genOptions;
    private final WorldSalts worldSalts;

    public WorldOptions(WorldSeed seed, WorldType type, String generatorOptions, WorldSalts worldSalts) {
        this.worldSeed = seed;
        this.worldType = type;
        this.genOptions = generatorOptions;
        this.worldSalts = worldSalts;
    }

    public WorldOptions(WorldSeed seed, WorldType type) {
        this(seed, type, "", new WorldSalts());
    }

    public WorldOptions(WorldSeed seed, WorldType type, WorldSalts worldSalts) {
        this(seed, type, "", worldSalts);
    }

    public WorldOptions withGeneratorOptions(String generatorOptions) {
        return new WorldOptions(worldSeed, worldType, generatorOptions, worldSalts);
    }

    public static WorldOptions fromSaveGame(SaveGame saveGame) {
        return new WorldOptions(WorldSeed.fromSaveGame(saveGame.getSeed()), saveGame.getWorldType(), saveGame.getGeneratorOptions(), new WorldSalts());
    }

    WorldSeed getWorldSeed() {
        return worldSeed;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public String getGeneratorOptions() {
        return genOptions;
    }

    WorldSalts getWorldSalts() {
        return worldSalts;
    }
}
