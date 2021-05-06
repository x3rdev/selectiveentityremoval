package github.x3rmination.selectiveentityremoval;

import com.google.gson.annotations.Expose;

import java.util.*;

public class Config {

    //THIS RANGE IS TEMPORARY FOR TESTING REMOVE LATER
    @Expose()
    public int range = 10;
    @Expose()
    public Map<String,Map<String,Object>> entities = new HashMap<>();



    public Config() {

        for(String entity: EntitiesList.minecraftEntitiesList){

            Map<String, Object> properties = new HashMap<>();
            properties.put("enabled", "true");
            properties.put("range", 60.0);

            entities.put(entity, properties);
        }
    }
}
