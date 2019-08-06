package amidst.mojangapi.world.versionfeatures;

@FunctionalInterface
public interface QuinFunction<P1, P2, P3, P4, P5, R> {
    R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
}
