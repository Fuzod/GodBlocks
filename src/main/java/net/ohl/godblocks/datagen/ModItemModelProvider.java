package net.ohl.godblocks.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ohl.godblocks.GodBlocks;
import net.ohl.godblocks.block.ModBlocks;
import net.ohl.godblocks.item.ModItems;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GodBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COCONUT);
        simpleItem(ModItems.COCONUT_HALF);
        simpleItem(ModItems.COCONUT_MILK);
        simpleItem(ModItems.STRAWBERRY_CAKE);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_SEEDS);

        simpleItem(ModItems.METAL_DETECTOR);

        handheldItem(ModItems.AMETHYST_SWORD);
        handheldItem(ModItems.AMETHYST_PICKAXE);
        handheldItem(ModItems.AMETHYST_AXE);
        handheldItem(ModItems.AMETHYST_SHOVEL);
        handheldItem(ModItems.AMETHYST_HOE);

        trimmedArmorItem(ModItems.AMETHYST_HELMET);
        trimmedArmorItem(ModItems.AMETHYST_CHESTPLATE);
        trimmedArmorItem(ModItems.AMETHYST_LEGGINGS);
        trimmedArmorItem(ModItems.AMETHYST_BOOTS);

        withExistingParent(ModItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private <T extends ItemLike> void simpleItem(RegistryObject<T> item) {
        String itemPath = item.getId().getPath();

        withExistingParent(itemPath, "item/generated")
                .texture(
                        "layer0",
                        ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "item/" + itemPath)
                );
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath();

        this.withExistingParent(GodBlocks.MOD_ID + ":" + blockPath,
                modLoc("block/" + blockPath));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath();

        this.withExistingParent(blockPath,
                modLoc("block/" + blockPath + "_bottom"));
    }

    public void fenceItem(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" + baseBlockPath));
    }

    public void fenceItemWithDefaultNamespace(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.withDefaultNamespace("block/" + baseBlockPath));
    }

    public void buttonItem(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" + baseBlockPath));
    }

    public void buttonItemWithDefaultNamespace(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.withDefaultNamespace("block/" + baseBlockPath));
    }

    public void wallItem(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "block/" + baseBlockPath));
    }

    public void wallItemWithDefaultNamespace(Block block, Block baseBlock) {
        String blockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        String baseBlockPath = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath();

        this.withExistingParent(blockPath, mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.withDefaultNamespace("block/" + baseBlockPath));
    }

    public void handheldItem(RegistryObject<Item> item) {
        String itemPath = item.getId().getPath();

        withExistingParent(itemPath,
                ResourceLocation.withDefaultNamespace("item/handheld")
        ).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(GodBlocks.MOD_ID, "item/" + itemPath));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = GodBlocks.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {

                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + itemRegistryObject.getId().getPath();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.withDefaultNamespace(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
