package z3roco01.effected;

import java.util.ArrayList;
import java.util.List;

public class ArmorEffects {
    private static final List<ArmorEffect> ARMOR_EFFECTS = new ArrayList<ArmorEffect>();

    public static ArmorEffect addArmorEffect(ArmorEffect effect) {
        ARMOR_EFFECTS.add(effect);
        return effect;
    }

    public static ArmorEffect removeArmorEffect(ArmorEffect effect) {
        ARMOR_EFFECTS.remove(effect);
        return effect;
    }

    public static Iterable<ArmorEffect> getArmorEffects() {
        return ARMOR_EFFECTS;
    }
}
