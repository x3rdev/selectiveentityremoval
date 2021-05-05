package github.x3rmination.selectiveentityremoval;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SelectiveEntityRemoval implements ModInitializer {

	private Thread cullThread;
	public Config config;
	public Set<BlockEntityType<?>> unCullable = new HashSet<>();

	@Override
	public void onInitialize() {
	}
}
