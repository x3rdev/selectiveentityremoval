package github.x3rmination.selectiveentityremoval;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SelectiveEntityRemoval implements ModInitializer {

	public static SelectiveEntityRemoval instance;
	private Thread cullThread;
	public Set<BlockEntityType<?>> unCullable = new HashSet<>();

	public static Config config;
	private final File settingsFile = new File("config", "selectiveentityremoval.json");
	private final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

	@Override
	public void onInitialize() {
		instance = this;
		if (settingsFile.exists()) {
			try {
				config = gson.fromJson(new String(Files.readAllBytes(settingsFile.toPath()), StandardCharsets.UTF_8), Config.class);
			} catch (Exception ex) {
				System.out.println("Error while loading config! Creating a new one!");
				ex.printStackTrace();
			}
		}
		if (config == null) {
			config = new Config();
			createConfig();
		}
	}

	public void createConfig() {
		if (settingsFile.exists()){
			settingsFile.delete();
		}

		try {
			Files.write(settingsFile.toPath(), gson.toJson(config).getBytes(StandardCharsets.UTF_8));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
