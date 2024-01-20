package org.adlin.simpleminecraftcheat.ui.custommenu;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class CustomScreen extends Screen {
    public CustomScreen() {
        super(Text.literal("Custom menu screen"));
    }

    private final MinecraftClient mc = MinecraftClient.getInstance();
    public ButtonWidget button1;
    public ButtonWidget button2;
    public ButtonWidget button3;
    public ButtonWidget button4;
    public ButtonWidget button5;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.translatable("simpleminecraftcheat.multiplayer"), button -> {
                    MinecraftClient.getInstance().setScreen(new MultiplayerScreen(this));
                })
                .dimensions(width / 2 - 90, 125, 180, 20)
                .build();
        button2 = ButtonWidget.builder(Text.translatable("simpleminecraftcheat.settings"), button -> {
                    MinecraftClient.getInstance().setScreen(new OptionsScreen(this, new GameOptions(mc , null)));
                })
                .dimensions(width / 2 - 90 , 150, 180, 20)
                .build();
        button3 = ButtonWidget.builder(Text.translatable("simpleminecraftcheat.singleplayer"),button ->{
            MinecraftClient.getInstance().setScreen(new SelectWorldScreen(this));
            })
                .dimensions(width/2 - 90 , 100 , 180 , 20)
                .build();
        button4 = ButtonWidget.builder(Text.translatable("simpleminecraftcheat.quit") , button -> {
                    mc.close();
                })
                .dimensions(width / 2 - 90 , 175, 180, 20)
                .build();

        addDrawableChild(button1);
        addDrawableChild(button2);
        addDrawableChild(button3);
        addDrawableChild(button4);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawCenteredTextWithShadow(mc.textRenderer , "Simple cheat" , width/2  , 25 , -1);
        super.render(context, mouseX, mouseY, delta);
    }
}