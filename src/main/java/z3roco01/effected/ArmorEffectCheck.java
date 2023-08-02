package z3roco01.effected;

import net.minecraft.item.ArmorMaterial;

public interface ArmorEffectCheck {
    // Returns true when it matches
    boolean check(ArmorMaterial material);
}
