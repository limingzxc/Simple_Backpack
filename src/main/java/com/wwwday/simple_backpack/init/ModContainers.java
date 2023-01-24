package com.wwwday.simple_backpack.init;

import com.wwwday.simple_backpack.Simple_Backpack;
import com.wwwday.simple_backpack.container.BackpackContainer;
import com.wwwday.simple_backpack.inventory.BackpackInventory;
import com.wwwday.simple_backpack.items.Backpack;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, Simple_Backpack.MOD_ID);

    public static final RegistryObject<ContainerType<BackpackContainer>> BIG_BACKPACK_CONTAINER
            = CONTAINERS.register("big_backpack_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                boolean isMainHand = inv.player.getMainHandItem().getItem() == ModItems.BIG_BACKPACK.get();
                Item item = isMainHand? inv.getSelected().getItem(): inv.player.getOffhandItem().getItem();
                Backpack backpack = item instanceof Backpack? (Backpack) item: null;
                BackpackInventory inventory =
                        new BackpackInventory(inv.getSelected(), inv.player, backpack != null? backpack.getRows(): 0);
                return BackpackContainer.sixRows(windowId, inv, inventory.getItemStackHandler(), isMainHand);
            })));

    public static final RegistryObject<ContainerType<BackpackContainer>> SMALL_BACKPACK_CONTAINER
            = CONTAINERS.register("small_backpack_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                boolean isMainHand = inv.player.getMainHandItem().getItem() == ModItems.SMALL_BACKPACK.get();
                Item item = isMainHand? inv.getSelected().getItem(): inv.player.getOffhandItem().getItem();
                Backpack backpack = item instanceof Backpack? (Backpack) item: null;
                BackpackInventory inventory =
                        new BackpackInventory(inv.getSelected(), inv.player, backpack != null? backpack.getRows(): 0);
                return BackpackContainer.threeRows(windowId, inv, inventory.getItemStackHandler(), isMainHand);
            })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
