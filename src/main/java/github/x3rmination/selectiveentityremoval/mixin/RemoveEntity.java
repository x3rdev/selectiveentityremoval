package github.x3rmination.selectiveentityremoval.mixin;

import github.x3rmination.selectiveentityremoval.Config;
import github.x3rmination.selectiveentityremoval.SelectiveEntityRemoval;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;


@Mixin(WorldRenderer.class)
public class RemoveEntity {

    private final int range = SelectiveEntityRemoval.instance.config.range;

    public double calculateCoordinateDifference(PlayerEntity player, Entity entity) {

        //player
        double playerXcoord = player.getX();
        double playerYcoord = player.getY();
        double playerZcoord = player.getZ();
        //entity
        double entityXcoord = entity.getX();
        double entityYcoord = entity.getY();
        double entityZcoord = entity.getZ();

        double distance = Math.round((Math.sqrt(
                Math.pow((playerXcoord-entityXcoord), 2)
                +Math.pow((playerYcoord-entityYcoord), 2)
                +Math.pow((playerZcoord-entityZcoord), 2)))*10000.0)/10000.0;

        return distance;

    }
    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta,
                              MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo callbackInfo) {

        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;


        if (entity.getType().toString().endsWith("item_frame")) {
            if (calculateCoordinateDifference(player, entity) > range) {
                callbackInfo.cancel();
            }
        }
    }
}
