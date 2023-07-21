package eu.tomger.flowerpower;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class FlowerPower {
    public static final String MOD_ID = "flower_power";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void initializeClient() {
        Arrays.stream(FlowerRegistry.Petals).forEach(blockSupplier -> {
                    var block = blockSupplier.get();
                    FlowerLayerManager.INSTANCE.putBlock(block, RenderType.cutout());
                    FlowerPower.LOGGER.info("Registered block '" + block.getName().getString() + "'.");
                }
        );
    }
    public static void initialize() {
        FlowerRegistry.initialize();
    }
}
