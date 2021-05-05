package github.x3rmination.selectiveentityremoval;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;


public class CalculateCoordDist {


    public void calculateCoordinateDifference(PlayerEntity player) {
        double playerXcoord = player.getX();
        double playerYcoord = player.getY();
        double playerZcoord = player.getZ();
        System.out.println(playerXcoord);
        System.out.println(playerYcoord);
        System.out.println(playerZcoord);

    }
}
