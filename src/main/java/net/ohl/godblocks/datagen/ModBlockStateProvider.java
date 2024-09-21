package net.ohl.godblocks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.ModBlocks;
import net.ohl.godblocks.block.custom.AmethystLampBlock;
import net.ohl.godblocks.block.custom.StrawberryCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GodBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GODBLOCK_T1);
        blockWithItem(ModBlocks.GODBLOCK_T2);
        blockWithItem(ModBlocks.GODBLOCK_T3);
        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        customLamp(ModBlocks.AMETHYST_LAMP.get(), AmethystLampBlock.CLICKED, "amethyst");
    }

    private void customLamp(Block block, BooleanProperty lampState, String lampName) {
        getVariantBuilder(block).forAllStates(state -> {
            if(state.getValue(lampState)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(lampName + "_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" + lampName + "_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(lampName + "_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" + lampName + "_lamp_off")))};
            }
        });
        simpleBlockItem(block, models().cubeAll(lampName + "_lamp_on",
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" +lampName + "_lamp_on")));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        var cropAgeProperty = ((StrawberryCropBlock) block).getAgeProperty();
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(cropAgeProperty),
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/"+ textureName + state.getValue(cropAgeProperty))).renderType("cutout"));
        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemAndMultiTexture(RegistryObject<Block> blockRegistryObject) {
        String blockPath = blockRegistryObject.getId().getPath();
        String fullBlockPath = "block/" + blockPath;
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop(blockPath,
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, fullBlockPath + "_side"),
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, fullBlockPath + "_bottom"),
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, fullBlockPath + "_top")));
    }
}
