package github.x3rmination.selectiveentityremoval;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ModConfigFileHandler {
    public static void readFromConfig() {
        JsonObject root = new JsonObject();
        Map<String, ModConfig.EntityEntryValues> map = ModConfig.getEntityTypes();
        try(FileReader reader = new FileReader(getConfigFile())) {
            root = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String entityKey : map.keySet().stream().sorted().toList()) {
            if(root.has(entityKey.concat(" range"))) {
                map.get(entityKey).setRange(root.get(entityKey.concat(" range")).getAsDouble());
            }
            if(root.has(entityKey.concat(" visible"))) {
                map.get(entityKey).setVisible(root.get(entityKey.concat(" visible")).getAsBoolean());
            }
        }

    }

    public static void writeToConfig() {
        JsonObject root = new JsonObject();
        Map<String, ModConfig.EntityEntryValues> map = ModConfig.getEntityTypes();
        for(String entityKey : map.keySet().stream().sorted().toList()) {
            root.addProperty(entityKey.concat(" range"), map.get(entityKey).getRange());
            root.addProperty(entityKey.concat(" visible"), map.get(entityKey).isVisible());
        }

        try(FileWriter writer = new FileWriter(getConfigFile())) {
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(root));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getConfigFile() {
        return FabricLoader.getInstance().getConfigDir().resolve(SelectiveEntityRemoval.MOD_ID.concat(".json")).toFile();
    }
}
