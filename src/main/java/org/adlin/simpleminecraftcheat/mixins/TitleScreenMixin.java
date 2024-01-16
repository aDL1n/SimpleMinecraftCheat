package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    private static MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(method = "render" , at = @At("RETURN") , cancellable = true)
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        init(context , mouseX , mouseY , delta , ci);
    }

    @Unique
    private static void init(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        context.drawText(mc.textRenderer , "UwU" , mc.getWindow().getScaledWidth() / 2  - mc.textRenderer.getWidth("UwU"),10 , -1 , true);
    }
}
