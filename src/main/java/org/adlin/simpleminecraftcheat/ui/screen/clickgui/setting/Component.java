package org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.ModuleButton;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;

import java.awt.*;

public class Component {

    public Settings settings;
    public  ModuleButton parent;
    public int offset;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Component(Settings settings, ModuleButton parent, int offset){
        this.settings = settings;
        this.parent = parent;
        this.offset = offset;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        //context.drawBorder(parent.parent.x, parent.parent.y + offset, parent.parent.width + 1, parent.parent.height + 1 + offset, Color.WHITE.getRGB());
        if(isHovered(mouseX ,mouseY)) context.fill(parent.parent.x, parent.parent.y + offset + parent.offset, parent.parent.x + parent.parent.width, parent.parent.y + offset + parent.parent.height + parent.offset , new Color(0 ,0 ,0 ,160).getRGB());
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {

    }
    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > parent.parent.x && mouseX < parent.parent.x + parent.parent.width && mouseY > parent.parent.y + parent.offset + offset && mouseY < parent.parent.y + parent.offset + offset + parent.parent.height;
    }
    public void keyPressed(int key) {
    }
}
