package github.x3rmination.selectiveentityremoval;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.chunk.WorldChunk;

public class CullTask implements Runnable{

    private final Set<BlockEntityType<?>> unCullable;
    private final MinecraftClient client = MinecraftClient.getInstance();

    public CullTask(Set<BlockEntityType<?>> unCullable) {
        this.unCullable = unCullable;
    }

    @Override
    public void run() {
        while (client.isRunning()) {
            Entity entity;
            Iterator<Entity> iterable = client.world.getEntities().iterator();
            while (iterable.hasNext()) {
                try {
                    entity = iterable.next();
                } catch (NullPointerException | ConcurrentModificationException ex) {
                    break; // We are not synced to the main thread, so NPE's/CME are allowed here and way less
                    // overhead probably than trying to sync stuff up for no really good reason
                }
                Cullable cullable = (Cullable) entity;

            }
        }
    }
}
