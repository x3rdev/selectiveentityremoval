package github.x3rmination.selectiveentityremoval;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class SelectiveEntityRemoval implements ClientModInitializer {

	public static final String MOD_ID = "selectiveentityremoval";
	private static List<EntityType<?>> entityTypes;
	{ instance = this; }
	private static SelectiveEntityRemoval instance;
	public static SelectiveEntityRemoval getInstance() {
		return instance;
	}


	private static final MinecraftClient client = MinecraftClient.getInstance();

	@Override
	public void onInitializeClient() {
		entityTypes = Registry.ENTITY_TYPE.stream().toList();
		ModConfig.setupConfigEntities(entityTypes);
		ModConfigFileHandler.readFromConfig();
	}

}
