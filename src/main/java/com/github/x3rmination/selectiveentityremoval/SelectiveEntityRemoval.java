package com.github.x3rmination.selectiveentityremoval;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;

import java.util.List;

public class SelectiveEntityRemoval implements ClientModInitializer {

	public static final String MOD_ID = "selectiveentityremoval";

	@Override
	public void onInitializeClient() {
		List<EntityType<?>> entityTypes = Registries.ENTITY_TYPE.stream().toList();
		ModConfig.setupConfigEntities(entityTypes);
		ModConfigFileHandler.readFromConfig();
	}

}
