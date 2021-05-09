package github.x3rmination.selectiveentityremoval;



import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.terraformersmc.modmenu.util.mod.Mod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigManager;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            return ModConfigManager.getConfigScreen(parent).get();
        };
    };


    private Screen configScreen(){

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parentScreen())
                .setTitle(new TranslatableText("title.SelectiveEntityRemoval.config"));

        return builder.build();

    }

    private Screen parentScreen(){
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" + MinecraftClient.getInstance().currentScreen);
        return MinecraftClient.getInstance().currentScreen;
    }






}
