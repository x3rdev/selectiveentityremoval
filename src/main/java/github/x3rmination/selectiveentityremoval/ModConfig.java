package github.x3rmination.selectiveentityremoval;

import com.google.gson.annotations.Expose;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.TranslatableText;


import java.util.*;




public class ModConfig {

    public static String testValue = "test";

    ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(SelectiveEntityRemoval.parentScreen)
            .setTitle(new TranslatableText("title.selectiveentityremoval.config"));



    ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("category.selectiveentityremoval.general"));

    ConfigEntryBuilder entryBuilder = builder.entryBuilder();




    @Expose()
    public Map<String,Map<String,Object>> entities = new HashMap<>();

    public ModConfig() {
        for(String entity: EntitiesList.minecraftEntitiesList){

            Map<String, Object> properties = new HashMap<>();
            properties.put("enabled", "true");
            properties.put("range", 60.0);

            entities.put(entity, properties);
        }
        general.addEntry(entryBuilder.startStrField(new TranslatableText("option.selectiveentityremoval.optionA"), testValue)
                .setDefaultValue("This is the default value")
                .setTooltip(new TranslatableText("This option is awesome!"))
                .setSaveConsumer(newValue -> testValue  = newValue)
                .build());
    }



}
