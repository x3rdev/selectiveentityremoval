package github.x3rmination.selectiveentityremoval;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.MinecraftClient;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.function.Supplier;

public class SelectiveEntityRemoval implements ModInitializer {

	public static SelectiveEntityRemoval instance;
	public static ModConfig modconfig;
	private final File settingsFile = new File("config", "selectiveentityremoval.json");
	private final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

	@Override
	public void onInitialize() {
		System.out.println("reached onIntialize -----------------------");
		instance = this;

		if (settingsFile.exists()) {
			try {
				modconfig = gson.fromJson(new String(Files.readAllBytes(settingsFile.toPath()), StandardCharsets.UTF_8), ModConfig.class);
			} catch (Exception ex) {
				System.out.println("Error while loading config! Creating a new one!");
				ex.printStackTrace();
			}
		}
		System.out.println("reached middleof onIntialize -----------------------");
		if (modconfig == null) {
			modconfig = new ModConfig();
			createConfig();
		}

		System.out.println("finished onIntialize -----------------------");
	}



	public void createConfig() {
		System.out.println("reached createConfig -----------------------");
		if (settingsFile.exists()){
			settingsFile.delete();
		}

		try {
			Files.write(settingsFile.toPath(), gson.toJson(modconfig).getBytes(StandardCharsets.UTF_8));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("reached end of createConfig -----------------------");
	}


}
