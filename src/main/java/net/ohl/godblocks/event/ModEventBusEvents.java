package net.ohl.godblocks.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.entity.ModEntities;
import net.ohl.godblocks.entity.custom.RhinoEntity;

@Mod.EventBusSubscriber(modid = GodBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }
}
