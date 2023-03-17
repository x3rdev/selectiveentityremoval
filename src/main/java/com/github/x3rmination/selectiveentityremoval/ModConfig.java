package com.github.x3rmination.selectiveentityremoval;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModConfig {

    private static final Map<String, EntityEntryValues> entityTypes = new HashMap<>();
    private static final double DEFAULT_RANGE = 100;
    private static Item configItem = Items.GLOW_ITEM_FRAME;

    private ModConfig() {
    }

    public static Screen getScreen(Screen parent) {
        ConfigBuilder builder = getScreenBuilder(parent);
        ConfigCategory general = builder.getOrCreateCategory(Text.translatable("text.config.selectiveentityremoval.title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        addConfigOptions(general, entryBuilder);
        builder.setSavingRunnable(ModConfigFileHandler::writeToConfig);
        return builder.build();
    }

    public static ConfigBuilder getScreenBuilder(Screen parent){
        return ConfigBuilder.create()
                .setParentScreen(parent)
                .setShouldListSmoothScroll(true)
                .setShouldTabsSmoothScroll(true)
                .setTransparentBackground(true)
                .setTitle(Text.translatable("text.config.selectiveentityremoval.title"));
    }

    public static void setupConfigEntities(List<EntityType<?>> entityList) {
        for (EntityType<?> type : entityList) {
            entityTypes.put(type.getTranslationKey(), new EntityEntryValues(DEFAULT_RANGE, true));
        }
    }

    private static void addConfigOptions(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
        for(String entity : entityTypes.keySet().stream().sorted().toList()) {
            SubCategoryBuilder entityCategory = entryBuilder.startSubCategory(Text.translatable(entity)).setExpanded(true);
            entityCategory.add(entryBuilder.startBooleanToggle(Text.translatable(entity).append(Text.of(" ")).append(Text.translatable("text.config.selectiveentityremoval.visible")), entityTypes.get(entity).visible)
                    .setDefaultValue(true)
                    .setSaveConsumer(aBoolean -> entityTypes.get(entity).setVisible(aBoolean))
                    .build());
            entityCategory.add(entryBuilder.startDoubleField(Text.translatable(entity).append(Text.of(" ")).append(Text.translatable("text.config.selectiveentityremoval.range")), entityTypes.get(entity).range)
                    .setDefaultValue(DEFAULT_RANGE)
                    .setSaveConsumer(aDouble -> entityTypes.get(entity).setRange(aDouble))
                    .build());
            category.addEntry(entityCategory.build());
        }
    }

    public static Map<String, EntityEntryValues> getEntityTypes() {
        return entityTypes;
    }

    public static class EntityEntryValues {

        private double range;
        private boolean visible;

        public EntityEntryValues(double range, boolean visible) {
            this.range = range;
            this.visible = visible;
        }

        public double getRange() {
            return range;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setRange(double range) {
            this.range = range;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }
    }
}
