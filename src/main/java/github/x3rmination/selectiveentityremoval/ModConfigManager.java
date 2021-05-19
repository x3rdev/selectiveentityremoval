package github.x3rmination.selectiveentityremoval;


import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.minecraft.client.gui.screen.Screen;
import java.util.function.Supplier;

public class ModConfigManager {

    public static ModConfig modconfig;

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


}
