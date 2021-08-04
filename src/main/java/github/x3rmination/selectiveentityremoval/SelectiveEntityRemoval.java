package github.x3rmination.selectiveentityremoval;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class SelectiveEntityRemoval implements ModInitializer {

	public static final String MOD_ID = "selectiveentityremoval";
	{ instance = this; }
	private static SelectiveEntityRemoval instance;
	public static SelectiveEntityRemoval getInstance() {
		return instance;
	}

	private static final MinecraftClient client = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {
		ModConfigManager.registerConfig();
		ModConfigManager.loadConfig();
	}


}
