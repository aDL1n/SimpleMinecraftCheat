package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import org.adlin.simpleminecraftcheat.modules.COMBAT.HitboxModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class RenderMixin {
    @Inject(method = "renderEntity" , at = @At("HEAD"))
    public void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci){
        if(entity instanceof PlayerEntity){
            if(entity != MinecraftClient.getInstance().player){
                System.out.println(HitboxModule.getSize());
                entity.setBoundingBox(new Box(
                        entity.getX() - HitboxModule.getSize(),
                        entity.getBoundingBox().minY,
                        entity.getZ() - HitboxModule.getSize(),
                        entity.getX() + HitboxModule.getSize(),
                        entity.getBoundingBox().maxY,
                        entity.getZ() + HitboxModule.getSize()
                ));
            }
        }
    }
}
