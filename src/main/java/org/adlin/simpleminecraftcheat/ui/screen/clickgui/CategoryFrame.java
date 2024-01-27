package org.adlin.simpleminecraftcheat.ui.screen.clickgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.Module;
import org.adlin.simpleminecraftcheat.modules.ModuleButton;
import org.adlin.simpleminecraftcheat.modules.ModuleManager;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting.Component;

import java.awt.*;
import java.util.ArrayList;

public class CategoryFrame {

    public int x, y, width, height, dragX, dragY;
    public Module.Category category;
    public boolean dragging, extended;
    private final ArrayList<ModuleButton> buttons;
    public MinecraftClient mc = MinecraftClient.getInstance();
    public CategoryFrame(int x, int y, int width, int height, Module.Category category) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;
        this.dragging = false;
        this.extended = false;
        buttons = new ArrayList<>();

        int offset = height;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(category)){
            buttons.add(new ModuleButton(module, this, offset));
            offset += height;
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        context.drawBorder(x, y, width + 1, height + 1 , Color.black.getRGB());
        context.fill(x ,y , x+width , y+height , -1);
        int offset = (height /2) - mc.textRenderer.fontHeight / 2;
        context.drawText(mc.textRenderer , category.name , x + offset , y+ offset  , Color.YELLOW.getRGB() , true);
        if (!buttons.isEmpty()){
            context.drawText(mc.textRenderer , extended ? "-" : "+" , x+ (width + 10) - (height /2) - mc.textRenderer.fontHeight / 2 - mc.textRenderer.getWidth("+") , y + (height /2) - mc.textRenderer.fontHeight / 2 , Color.YELLOW.getRGB() , true);
        }

        if(extended){
            for(ModuleButton button : buttons){
                button.render(context, mouseX, mouseY, delta);
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX , mouseY)) {
            if(button == 0){
                dragging = true;
                dragX = (int) (mouseX - x);
                dragY = (int) (mouseY - y);
            } else if (button == 1) {
                extended = !extended;
            }

        }
        if(extended){
            for(ModuleButton moduleButton : buttons){
                moduleButton.mouseClicked(mouseX, mouseY, button);
            }
        }
    }

    public void mouseRelease(double mouseX, double mouseY, int button){
        if(button == 0 && dragging) dragging = false;

        for(ModuleButton mb : buttons) {
            mb.mouseRelease(mouseX  ,mouseY ,button);
        }
    }

    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void updatePosition(double mouseX, double mouseY){
        if(dragging){
            x = (int) (mouseX - dragX);
            y = (int) (mouseY - dragY);
        }
    }

    public void keyPressed(int key) {
        for (ModuleButton mb : buttons) {
            mb.keyPressed(key);
        }
    }
    public void updateButtons(){
        int offset = height;

        for(ModuleButton button : buttons){
            button.offset = offset;
            offset += height;

            if(button.extended){
                for(Component component : button.components){
                    if(component.settings.isVisible()) offset += height;
                }
            }
        }
    }
}
