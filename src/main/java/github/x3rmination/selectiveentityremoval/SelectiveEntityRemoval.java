package github.x3rmination.selectiveentityremoval;

import net.fabricmc.api.ModInitializer;

public class SelectiveEntityRemoval implements ModInitializer {



	@Override
	public void onInitialize() {
		ModConfigManager.registerConfig();
		ModConfigManager.loadConfig();
		ModConfigManager.checkConfig();
		ModConfigManager.createConfig();
	}






}
