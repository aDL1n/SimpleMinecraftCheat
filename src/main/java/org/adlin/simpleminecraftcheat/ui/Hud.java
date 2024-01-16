package org.adlin.simpleminecraftcheat.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.Module;
import org.adlin.simpleminecraftcheat.modules.ModuleManager;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.List;

public class Hud {

    private static final MinecraftClient mc = MinecraftClient.getInstance();
    public static void render(DrawContext context , float tickDelta, CallbackInfo ci){
//        if(!mc.getDebugHud().shouldShowDebugHud()){
//            //context.drawText(mc.textRenderer , "Test" , 10 ,10 , -1 , true);
//        }
        renderArrayList(context);

    }

    public static void renderArrayList(DrawContext context){
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<Module> enabled = ModuleManager.INSTANCE.getEnabledModules();
        enabled.sort(Comparator.comparingInt(m -> mc.textRenderer.getWidth(((Module)m).getDisplayName())).reversed());

        for(Module module: enabled){
            context.drawText(mc.textRenderer , module.getDisplayName() , (sWidth - 4) - mc.textRenderer.getWidth(module.getDisplayName()) , 10 + (index * mc.textRenderer.fontHeight) , -1 , true);
            index++;
        }
    }
}
