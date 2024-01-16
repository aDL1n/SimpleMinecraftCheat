package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.ui.GameMenuScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.GameMenuScreen.class)
public class GameMenuScreenMixin {
    @Inject(method = "render" , at= @At("RETURN") , cancellable = true)
    public void renderScreen(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        GameMenuScreen.render(context ,mouseX , mouseY, delta , ci);
    }
}
