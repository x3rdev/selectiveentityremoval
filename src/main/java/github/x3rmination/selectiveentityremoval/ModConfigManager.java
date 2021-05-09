package github.x3rmination.selectiveentityremoval;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.minecraft.client.gui.screen.Screen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModConfigManager {



    public static SelectiveEntityRemoval instance;
    public static ModConfig modconfig;
    private static final File settingsFile = new File("config", "selectiveentityremoval.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();


    public static void registerConfig() {
        AutoConfig.register(
                ModConfig.class,
                PartitioningSerializer.wrap(GsonConfigSerializer::new)
        );
    }

    public static void loadConfig() {
        modconfig = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static Supplier<Screen> getConfigScreen(Screen parent) {
        return AutoConfig.getConfigScreen(ModConfig.class, parent);
    }


    public static void checkConfig() {
        if (settingsFile.exists()) {
            try {
                modconfig = gson.fromJson(new String(Files.readAllBytes(settingsFile.toPath()), StandardCharsets.UTF_8), ModConfig.class);
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
        if (modconfig == null) {
            modconfig = new ModConfig();
            createConfig();
        }
    }


    public static void createConfig() {
        if (settingsFile.exists()){
            settingsFile.delete();
        }

        try {
            Files.write(settingsFile.toPath(), gson.toJson(modconfig).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

//    @Expose()
//    public Map<String, Map<String,Object>> entities = new HashMap<>();

    //    public ModConfig() {
//        for(String entity: EntitiesList.minecraftEntitiesList){
//
//            Map<String, Object> properties = new HashMap<>();
//            properties.put("enabled", "true");
//            properties.put("range", 60.0);
//
//            entities.put(entity, properties);
//        }
//
//    }
}
