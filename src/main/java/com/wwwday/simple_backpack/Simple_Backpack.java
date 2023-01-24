package com.wwwday.simple_backpack;

import com.wwwday.simple_backpack.init.ModContainers;
import com.wwwday.simple_backpack.init.ModItems;
import com.wwwday.simple_backpack.screen.BackpackScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Simple_Backpack.MOD_ID)
public class Simple_Backpack {
    public static final String MOD_ID = "simple_backpack";

//    private static final Logger LOGGER = LogManager.getLogger();

    public Simple_Backpack() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModContainers.register(eventBus);

        eventBus.addListener(this::doClientStuff);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

            ScreenManager.register(ModContainers.BIG_BACKPACK_CONTAINER.get(),
                    BackpackScreen::new);

            ScreenManager.register(ModContainers.SMALL_BACKPACK_CONTAINER.get(),
                    BackpackScreen::new);
        });
    }
}
