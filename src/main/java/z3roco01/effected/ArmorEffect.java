package z3roco01.effected;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorMaterial;

public class ArmorEffect {
    private final StatusEffect     effect;
    private final ArmorEffectCheck check;
    private final ArmorEffectCalc  calc;
    private final String id;

    public ArmorEffect(StatusEffect effect, ArmorEffectCheck check, ArmorEffectCalc calc, String id) {
        this.effect = effect;
        this.check  = check;
        this.calc   = calc;
        this.id      = id;
    }

    public boolean check(ArmorMaterial material) {
        return check.check(material);
    }

    public int calc(int armors) {
        return calc.calc(armors);
    }

    public StatusEffect getEffect() {
        return effect;
    }

    public StatusEffectInstance getEffectInstance(int armors) {
        int amplifier = calc(armors);
        if(amplifier > 0) return new StatusEffectInstance(effect, 100, amplifier-1, false, false, false);
        return null;
    }

    public String getId() {
        return id;
    }
}
