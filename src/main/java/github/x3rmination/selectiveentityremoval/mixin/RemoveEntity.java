package github.x3rmination.selectiveentityremoval.mixin;

import github.x3rmination.selectiveentityremoval.ConfigProvider;
import github.x3rmination.selectiveentityremoval.ModConfig;
import github.x3rmination.selectiveentityremoval.SelectiveEntityRemoval;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.game.MinecraftGameProvider;
import net.fabricmc.loom.configuration.providers.MinecraftProvider;
import net.minecraft.MinecraftVersion;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class RemoveEntity {

    ConfigProvider configProvider = new ConfigProvider(AutoConfig.getConfigHolder(ModConfig.class).getConfig());

    public double calculate2dCoordinateDifference(PlayerEntity player, Entity entity) {

        //player
        double playerXcoord = player.getX();
        double playerZcoord = player.getZ();
        //entity
        double entityXcoord = entity.getX();
        double entityZcoord = entity.getZ();

        double distance = Math.round((Math.sqrt(Math.pow((playerXcoord - entityXcoord), 2) + Math.pow((playerZcoord - entityZcoord), 2))) * 10000.0) / 10000.0;

        return distance;

    }


    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta,
                              MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo callbackInfo) {

        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        assert player != null;

        String targetEntity = (entity.getType().toString()).replace("entity.minecraft.", "");

        //isEnabled changed to isVisible for clarity, if the entity is Disabled it will never be visible,
        //if entity is Enabled it will be visible as long as it is within range


        if (MinecraftClient.getInstance().options.entityDistanceScaling * 160 > calculate2dCoordinateDifference(player, entity)) {
            boolean isVisible = configProvider.getEnabledFor(targetEntity);
            double range = configProvider.getRangeFor(targetEntity);
            if (isVisible) {
                if (player.distanceTo(entity) > range) {
                    callbackInfo.cancel();
                }
            }
            if (!isVisible) {
                callbackInfo.cancel();
            }
        }
    }

}
