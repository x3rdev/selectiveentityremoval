package github.x3rmination.selectiveentityremoval.mixin;

import github.x3rmination.selectiveentityremoval.ConfigProvider;
import github.x3rmination.selectiveentityremoval.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WorldRenderer.class, priority = 2000)
public abstract class RemoveEntity {

    @Shadow protected abstract void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers);

    ConfigProvider configProvider = new ConfigProvider(AutoConfig.getConfigHolder(ModConfig.class).getConfig());

    public double calculate2dCoordinateDifference(PlayerEntity player, Entity entity) {

        //player
        double playerXcoord = player.getX();
        double playerZcoord = player.getZ();
        //entity
        double entityXcoord = entity.getX();
        double entityZcoord = entity.getZ();

        return Math.round((Math.sqrt(Math.pow((playerXcoord - entityXcoord), 2) + Math.pow((playerZcoord - entityZcoord), 2))) * 10000.0) / 10000.0;

    }


    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta,
                              MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo callbackInfo) {

        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        assert player != null;

        String targetEntity = (entity.getType().toString()).replace("entity.minecraft.", "");
        boolean isVisible = configProvider.getEnabledFor(targetEntity);
        if (!isVisible) {
            callbackInfo.cancel();
        }
        //isEnabled changed to isVisible for clarity, if the entity is Disabled it will never be visible,
        //if entity is Enabled it will be visible as long as it is within range
        if (MinecraftClient.getInstance().options.entityDistanceScaling * 160 > calculate2dCoordinateDifference(player, entity)) {
            double range = configProvider.getRangeFor(targetEntity);
            if (player.distanceTo(entity) > range) {
                callbackInfo.cancel();
            }
        }
    }

}
