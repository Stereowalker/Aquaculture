package com.teammetallurgy.aquaculture.misc;

import com.teammetallurgy.aquaculture.Aquaculture;
import com.teammetallurgy.aquaculture.api.AquacultureAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Aquaculture.MOD_ID, value = Dist.CLIENT)
public class AquaTooltip {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if (!event.getItemStack().isEmpty()) {
            Item item = event.getItemStack().getItem();
            if (!item.getTags().isEmpty() && item.isIn(AquacultureAPI.Tags.TOOLTIP)) {
                if (item.getRegistryName() != null) {
                    String itemIdentifier = item.getRegistryName().getPath() + ".tooltip";
                    if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
                        event.getToolTip().add(new TranslationTextComponent(Aquaculture.MOD_ID + "." + itemIdentifier + ".desc").func_240699_a_(TextFormatting.AQUA));
                    } else {
                        event.getToolTip().add(new TranslationTextComponent(Aquaculture.MOD_ID + "." + itemIdentifier + ".title").func_240699_a_(TextFormatting.AQUA)
                                .func_240702_b_(" ").func_230529_a_(new TranslationTextComponent(Aquaculture.MOD_ID + ".shift").func_240699_a_(TextFormatting.DARK_GRAY)));
                    }
                }
            }
        }
    }
}