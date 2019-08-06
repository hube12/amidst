package amidst.mojangapi.world;

import java.util.Random;

import amidst.documentation.Immutable;
import amidst.mojangapi.minecraftinterface.RecognisedVersion;
import amidst.mojangapi.world.biome.Biome;
import amidst.mojangapi.world.versionfeatures.VersionFeature;

@Immutable
public class WorldSalts {
    private VersionFeature<Long> seedForStructure_DesertTemple;
    private VersionFeature<Long> seedForStructure_Igloo;
    private VersionFeature<Long> seedForStructure_JungleTemple;
    private VersionFeature<Long> seedForStructure_WitchHut;
    private VersionFeature<Long> seedForStructure_OceanRuins;
    private VersionFeature<Long> seedForStructure_Shipwreck;
    private VersionFeature<Long> seedForStructure_BuriedTreasure;
    private VersionFeature<Long> seedForStructure_OceanMonument;
    private VersionFeature<Long> seedForStructure_WoodlandMansion;
    private VersionFeature<Long> seedForStructure_EndCity;
    private VersionFeature<Long> seedForStructure_Village;
    private VersionFeature<Long> seedForStructure_SlimeChunk;
    private VersionFeature<Long> seedForStructure_PillagerOutpost;

    public WorldSalts() {
        this.seedForStructure_DesertTemple = VersionFeature.<Long>builder()
                .init(
                        14357617L
                ).construct();
        this.seedForStructure_Igloo = VersionFeature.<Long>builder()
                .init(
                        14357617L
                ).since(RecognisedVersion._18w06a,
                        14357618L
                ).construct();
        this.seedForStructure_JungleTemple = VersionFeature.<Long>builder()
                .init(
                        14357617L
                ).since(RecognisedVersion._18w06a,
                        14357619L
                ).construct();
        this.seedForStructure_WitchHut = VersionFeature.<Long>builder()
                .init(
                        14357617L
                ).since(RecognisedVersion._18w06a,
                        14357620L
                ).construct();
        this.seedForStructure_OceanRuins = VersionFeature.<Long>builder()
                .init(
                        14357621L
                ).construct();
        this.seedForStructure_Shipwreck = VersionFeature.<Long>builder()
                .init(
                        165745295L
                ).construct();
        this.seedForStructure_BuriedTreasure = VersionFeature.<Long>builder()
                .init(
                        10387320L
                ).construct();

        this.seedForStructure_OceanMonument = VersionFeature.<Long>builder()
                .init(
                        10387313L
                ).construct();
        this.seedForStructure_WoodlandMansion = VersionFeature.<Long>builder()
                .init(
                        10387319L
                ).construct();
        this.seedForStructure_EndCity = VersionFeature.<Long>builder()
                .init(
                        10387313L
                ).construct();
        this.seedForStructure_Village = VersionFeature.<Long>builder()
                .init(
                        10387312L
                ).construct();
        this.seedForStructure_SlimeChunk = VersionFeature.<Long>builder()
                .init(
                        987234911L
                ).construct();
        this.seedForStructure_PillagerOutpost = VersionFeature.<Long>builder()
                .init(
                        165745296L
                ).construct();
    }

    public VersionFeature<Long> getSeedForStructure_PillagerOutpost() {
        return seedForStructure_PillagerOutpost;
    }

    public void setSeedForStructure_PillagerOutpost(VersionFeature<Long> seedForStructure_PillagerOutpost) {
        this.seedForStructure_PillagerOutpost = seedForStructure_PillagerOutpost;
    }

    public VersionFeature<Long> getSeedForStructure_DesertTemple() {
        return seedForStructure_DesertTemple;
    }

    public VersionFeature<Long> getSeedForStructure_Igloo() {
        return seedForStructure_Igloo;
    }

    public VersionFeature<Long> getSeedForStructure_JungleTemple() {
        return seedForStructure_JungleTemple;
    }

    public VersionFeature<Long> getSeedForStructure_WitchHut() {
        return seedForStructure_WitchHut;
    }

    public VersionFeature<Long> getSeedForStructure_OceanRuins() {
        return seedForStructure_OceanRuins;
    }

    public VersionFeature<Long> getSeedForStructure_Shipwreck() {
        return seedForStructure_Shipwreck;
    }

    public void setSeedForStructure_DesertTemple(VersionFeature<Long> seedForStructure_DesertTemple) {
        this.seedForStructure_DesertTemple = seedForStructure_DesertTemple;
    }

    public void setSeedForStructure_Igloo(VersionFeature<Long> seedForStructure_Igloo) {
        this.seedForStructure_Igloo = seedForStructure_Igloo;
    }

    public void setSeedForStructure_JungleTemple(VersionFeature<Long> seedForStructure_JungleTemple) {
        this.seedForStructure_JungleTemple = seedForStructure_JungleTemple;
    }

    public void setSeedForStructure_WitchHut(VersionFeature<Long> seedForStructure_WitchHut) {
        this.seedForStructure_WitchHut = seedForStructure_WitchHut;
    }

    public void setSeedForStructure_OceanRuins(VersionFeature<Long> seedForStructure_OceanRuins) {
        this.seedForStructure_OceanRuins = seedForStructure_OceanRuins;
    }

    public void setSeedForStructure_Shipwreck(VersionFeature<Long> seedForStructure_Shipwreck) {
        this.seedForStructure_Shipwreck = seedForStructure_Shipwreck;
    }

    public void setSeedForStructure_BuriedTreasure(VersionFeature<Long> seedForStructure_BuriedTreasure) {
        this.seedForStructure_BuriedTreasure = seedForStructure_BuriedTreasure;
    }

    public VersionFeature<Long> getSeedForStructure_BuriedTreasure() {
        return seedForStructure_BuriedTreasure;
    }

    public VersionFeature<Long> getSeedForStructure_OceanMonument() {
        return seedForStructure_OceanMonument;
    }

    public void setSeedForStructure_OceanMonument(VersionFeature<Long> seedForStructure_OceanMonument) {
        this.seedForStructure_OceanMonument = seedForStructure_OceanMonument;
    }

    public VersionFeature<Long> getSeedForStructure_WoodlandMansion() {
        return seedForStructure_WoodlandMansion;
    }

    public void setSeedForStructure_WoodlandMansion(VersionFeature<Long> seedForStructure_WoodlandMansion) {
        this.seedForStructure_WoodlandMansion = seedForStructure_WoodlandMansion;
    }

    public VersionFeature<Long> getSeedForStructure_EndCity() {
        return seedForStructure_EndCity;
    }

    public void setSeedForStructure_EndCity(VersionFeature<Long> seedForStructure_EndCity) {
        this.seedForStructure_EndCity = seedForStructure_EndCity;
    }

    public VersionFeature<Long> getSeedForStructure_Village() {
        return seedForStructure_Village;
    }

    public void setSeedForStructure_Village(VersionFeature<Long> seedForStructure_Village) {
        this.seedForStructure_Village = seedForStructure_Village;
    }

    public VersionFeature<Long> getSeedForStructure_SlimeChunk() {
        return seedForStructure_SlimeChunk;
    }

    public void setSeedForStructure_SlimeChunk(VersionFeature<Long> seedForStructure_SlimeChunk) {
        this.seedForStructure_SlimeChunk = seedForStructure_SlimeChunk;
    }
}
