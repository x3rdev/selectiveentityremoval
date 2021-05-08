package github.x3rmination.selectiveentityremoval;

import com.google.gson.annotations.Expose;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screen.Screen;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class ModConfig {

    public static String testValue = "test";


    @Expose()
    public Map<String,Map<String,Object>> entities = new HashMap<>();

    public ModConfig() {
        for(String entity: EntitiesList.minecraftEntitiesList){

            Map<String, Object> properties = new HashMap<>();
            properties.put("enabled", "true");
            properties.put("range", 60.0);

            entities.put(entity, properties);
        }
//        general.addEntry(entryBuilder.startStrField(new TranslatableText("option.selectiveentityremoval.optionA"), testValue)
//                .setDefaultValue("This is the default value")
//                .setTooltip(new TranslatableText("This option is awesome!"))
//                .setSaveConsumer(newValue -> testValue  = newValue)
//                .build());
    }



}
