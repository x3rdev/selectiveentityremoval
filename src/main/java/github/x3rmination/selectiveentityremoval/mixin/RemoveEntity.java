package github.x3rmination.selectiveentityremoval.mixin;

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



    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta,
                              MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo callbackInfo) {
        System.out.println("3456785rt62de3rwtwefrdiewtydfjytsafjdgasfdjs");
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;
        calculateCoordinateDifference(player);

        if(entity.getType().toString().endsWith("pig")){
            callbackInfo.cancel();
        }
    }
    public void calculateCoordinateDifference(PlayerEntity player) {
        System.out.println("wwww 3456785rt62de3rwtwefrdiewtydfjytsafjdgasfdjs");

        double playerXcoord = player.getX();
        double playerYcoord = player.getY();
        double playerZcoord = player.getZ();
        System.out.println("X="+playerXcoord);
        System.out.println("Y="+playerYcoord);
        System.out.println("Z="+playerZcoord);

    }

}
