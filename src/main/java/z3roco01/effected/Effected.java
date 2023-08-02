package z3roco01.effected;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Effected implements ModInitializer {
    public static final String MOD_ID = "effected";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
    	LOGGER.info("Starting init !");



    	LOGGER.info("Finished init !");
    }
}
