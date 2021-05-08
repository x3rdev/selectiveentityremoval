package github.x3rmination.selectiveentityremoval;



import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> configScreen();
    }


    private Screen configScreen(){

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parentScreen())
                .setTitle(new TranslatableText("title.examplemod.config"));

        return builder.build();

    }

    private Screen parentScreen(){
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" + MinecraftClient.getInstance().currentScreen);
        return MinecraftClient.getInstance().currentScreen;
    }






}
