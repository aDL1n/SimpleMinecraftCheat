package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.adlin.simpleminecraftcheat.Client;
import org.adlin.simpleminecraftcheat.ui.custommenu.CustomScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Unique
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "render" , at = @At("RETURN") , cancellable = true)
    public void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        //mc.setScreen(new CustomScreen());
    }

    @Unique
    private static void initText(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci){
        context.drawText(mc.textRenderer , "UwU" , mc.getWindow().getScaledWidth() / 2  - mc.textRenderer.getWidth("UwU"),10 , -1 , true);
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addModsButton(int y, int spacingY, CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("simpleminecraftcheat.changemenu"), (button) -> {
            this.client.setScreen(new CustomScreen());
        }).dimensions(this.width / 2 + 105, y, 60, 20).build());
    }
}
