package themcbros.usefulmachinery.proxy;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import themcbros.usefulmachinery.client.gui.*;
import themcbros.usefulmachinery.init.ModContainers;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainers.COAL_GENERATOR, CoalGeneratorScreen::new);
        ScreenManager.registerFactory(ModContainers.LAVA_GENERATOR, LavaGeneratorScreen::new);
        ScreenManager.registerFactory(ModContainers.CRUSHER, CrusherScreen::new);
        ScreenManager.registerFactory(ModContainers.ELECTRIC_SMELTER, ElectricSmelterScreen::new);
        ScreenManager.registerFactory(ModContainers.COMPACTOR, CompactorScreen::new);
    }

}
