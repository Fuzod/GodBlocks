package net.ohl.godblocks.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GodBlocks.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> GODBLOCK_BREAK = registerSoundEvents("godblock_break");
    public static final RegistryObject<SoundEvent> GODBLOCK_STEP = registerSoundEvents("godblock_step");
    public static final RegistryObject<SoundEvent> GODBLOCK_FALL = registerSoundEvents("godblock_fall");
    public static final RegistryObject<SoundEvent> GODBLOCK_PLACE = registerSoundEvents("godblock_place");
    public static final RegistryObject<SoundEvent> GODBLOCK_HIT = registerSoundEvents("godblock_hit");

    public static final ForgeSoundType GODBLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.GODBLOCK_BREAK,
            ModSounds.GODBLOCK_STEP,
            ModSounds.GODBLOCK_PLACE,
            ModSounds.GODBLOCK_HIT,
            ModSounds.GODBLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String soundName) {
        return SOUND_EVENT.register(soundName,
                () -> SoundEvent.createVariableRangeEvent(
                        ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, soundName)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
