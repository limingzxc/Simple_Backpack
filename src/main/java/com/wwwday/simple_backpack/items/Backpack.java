package com.wwwday.simple_backpack.items;

import com.wwwday.simple_backpack.inventory.BackpackInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class Backpack extends Item {
    private final int pRows;

    public Backpack(int pRows) {
        super(new Properties().stacksTo(1).tab(ItemGroup.TAB_TOOLS));
        this.pRows = pRows;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);

        if(!pLevel.isClientSide()) {
            if(itemStack.getItem() instanceof Backpack) {
                BackpackInventory.openGUI((ServerPlayerEntity) pPlayer, itemStack, pRows);
            }
        }
        return ActionResult.sidedSuccess(itemStack, pLevel.isClientSide);
    }

    public int getRows() {
        return pRows;
    }
}
