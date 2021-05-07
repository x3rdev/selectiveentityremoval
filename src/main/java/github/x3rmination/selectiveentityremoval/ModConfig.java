package github.x3rmination.selectiveentityremoval;

import com.google.gson.annotations.Expose;
import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.api.ConfigGroup;


import java.util.*;




public class ModConfig implements ConfigGroup {



    @Override
    public String getID() {
        return "TestConfig";
    }

    @ConfigEntry
    private int myIntSetting = 10;


    @Override
    public ConfigContainer[] getTransitives() {
        return new ConfigContainer[]{new ModConfig()};

    }


    @Expose()
    public Map<String,Map<String,Object>> entities = new HashMap<>();

    public ModConfig() {
        for(String entity: EntitiesList.minecraftEntitiesList){

            Map<String, Object> properties = new HashMap<>();
            properties.put("enabled", "true");
            properties.put("range", 60.0);

            entities.put(entity, properties);
        }
    }
}
