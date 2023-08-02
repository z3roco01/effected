package z3roco01.effected;

public interface ArmorEffectCalc {
    // Returns effect amplifier and takes the number of matching armor pieces
    // amplifier of one would normally be effect lvl 2 but will be effect lvl 1
    int calc(int armors);
}
