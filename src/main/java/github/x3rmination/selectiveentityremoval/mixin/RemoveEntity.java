package github.x3rmination.selectiveentityremoval.mixin;

import github.x3rmination.selectiveentityremoval.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WorldRenderer.class, priority = 2000)
public abstract class RemoveEntity {

//    ConfigProvider configProvider = new ConfigProvider(AutoConfig.getConfigHolder(ModConfig.class).getConfig());

    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta,
                              MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo callbackInfo) {

        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        assert player != null;

        String targetEntity = entity.getType().getTranslationKey();
        boolean isVisible = ModConfig.getEntityTypes().get(targetEntity).isVisible();
        if (!isVisible) {
            callbackInfo.cancel();
        }

        if (MinecraftClient.getInstance().options.getEntityDistanceScaling().getValue() * 160 > player.squaredDistanceTo(player)) {
            double range = ModConfig.getEntityTypes().get(targetEntity).getRange();
            if (player.squaredDistanceTo(entity) > Math.pow(range, 2)) {
                callbackInfo.cancel();
            }
        }
    }
}
