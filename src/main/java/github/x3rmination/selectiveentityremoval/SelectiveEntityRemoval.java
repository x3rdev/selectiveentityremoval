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
	public CullTask cullTask;
	public Set<BlockEntityType<?>> unCullable = new HashSet<>();

	@Override
	public void onInitialize() {

		cullTask = new CullTask(unCullable);

//		for(String blockId : config.blockEntityWhitelist) {
//			Optional<BlockEntityType<?>> block = Registry.BLOCK_ENTITY_TYPE.getOrEmpty(new Identifier(blockId));
//			block.ifPresent(b -> {
//				unCullable.add(b);
//			});
//		}
		cullThread = new Thread(cullTask, "CullThread");
		cullThread.setUncaughtExceptionHandler((thread, ex) -> {
			System.out.println("The CullingThread has crashed! Please report the following stacktrace!");
			ex.printStackTrace();
		});
		cullThread.start();
	}
}
