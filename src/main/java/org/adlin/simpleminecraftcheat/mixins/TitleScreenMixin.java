package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.adlin.simpleminecraftcheat.ui.custommenu.CustomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin{
    @Unique
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    @Inject(method = "render" , at = @At("RETURN") , cancellable = true)
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        initText(context , mouseX , mouseY , delta , ci);
        mc.setScreen(new CustomScreen());
    }


    @Unique
    private static void initText(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        context.drawText(mc.textRenderer , "UwU" , mc.getWindow().getScaledWidth() / 2  - mc.textRenderer.getWidth("UwU"),10 , -1 , true);
    }
}
