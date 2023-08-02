package z3roco01.effected.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import z3roco01.effected.ArmorEffect;
import z3roco01.effected.ArmorEffects;

import java.util.HashMap;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Inject(at = @At("TAIL"), method = "tick", cancellable = false)
    public void tick(CallbackInfo ci) {
        this.updateArmorEffects();
    }

    @Unique
    private void updateArmorEffects() {
        HashMap<String, Integer> effectArmorsMap = new HashMap();

        for(ItemStack stack : getArmorItems()) {
            Item item = stack.getItem();
            if(item instanceof ArmorItem) {
                ArmorMaterial material = ((ArmorItem)item).getMaterial();

                // Increment match counter if the material matches
                for(ArmorEffect effect : ArmorEffects.getArmorEffects())
                    if(effect.check(material)) effectArmorsMap.put(effect.getId(), effectArmorsMap.getOrDefault(effect.getId(), 0)+1);
            }
        }

        for(ArmorEffect effect : ArmorEffects.getArmorEffects()) {
            StatusEffectInstance effectToAdd = effect.getEffectInstance(effectArmorsMap.getOrDefault(effect.getId(), 0));
            if(effectToAdd != null) this.addStatusEffect(effectToAdd);
        }
    }
}
