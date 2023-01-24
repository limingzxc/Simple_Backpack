package com.wwwday.simple_backpack.init;

import com.wwwday.simple_backpack.Simple_Backpack;
import com.wwwday.simple_backpack.items.Backpack;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Simple_Backpack.MOD_ID);

    public static final RegistryObject<Item> BIG_BACKPACK = ITEMS.register("big_backpack",
            () -> new Backpack(6));

    public static final RegistryObject<Item> SMALL_BACKPACK = ITEMS.register("small_backpack",
            () -> new Backpack(3));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
