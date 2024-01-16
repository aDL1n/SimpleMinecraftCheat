package org.adlin.simpleminecraftcheat.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class GameMenuScreen {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static void render(DrawContext context  ,int mouseX , int mouseY, float delta, CallbackInfo ci){
        context.drawText(mc.textRenderer , "UwU" , 10 ,10 , -1 , true);
    }
}
