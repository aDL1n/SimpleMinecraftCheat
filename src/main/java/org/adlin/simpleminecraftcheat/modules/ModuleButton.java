package org.adlin.simpleminecraftcheat.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.settings.BooleanSettings;
import org.adlin.simpleminecraftcheat.modules.settings.ModeSettings;
import org.adlin.simpleminecraftcheat.modules.settings.NumberSettings;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.CategoryFrame;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting.CheckBox;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting.Component;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting.ModeBox;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting.Slider;

import java.awt.*;
import java.util.ArrayList;

public class ModuleButton {

    public Module module;
    public CategoryFrame parent;
    public int offset;
    private final MinecraftClient mc = MinecraftClient.getInstance();
    public ArrayList<Component> components;
    public boolean extended;

    public ModuleButton(Module module, CategoryFrame frame, int offset){
        this.module = module;
        this.parent = frame;
        this.offset = offset;
        this.extended = false;
        this.components = new ArrayList<>();

        int setOffset = parent.height;
        for(Settings settings : module.getSettings()){
            if(settings instanceof BooleanSettings){
                components.add(new CheckBox(settings , this, setOffset));
            }else if(settings instanceof ModeSettings){
                components.add(new ModeBox(settings , this, setOffset));
            }else if(settings instanceof NumberSettings){
                components.add(new Slider(settings , this, setOffset));
            }
            setOffset += parent.height;
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        int offsetY = ((parent.height / 2) - parent.mc.textRenderer.fontHeight / 2);
        context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height , new Color(0 ,0 ,0 ,160).getRGB());
        if(isHovered(mouseX ,mouseY)) context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height , new Color(0 ,0 ,0 ,160).getRGB());
        context.drawText(mc.textRenderer, module.getDisplayName() , parent.x + offsetY, parent.y + offsetY + offset,module.isEnabled() ? Color.YELLOW.getRGB() : -1 , true);
        if(extended){
            for (Component component : components){
                component.render(context, mouseX, mouseY, delta);
            }
        }

    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX, mouseY)){
            if(button == 0){
                module.toggle();
            }else if(button == 1){
                extended = !extended;
                parent.updateButtons();
            }
        }
        for (Component component : components){
            component.mouseClicked(mouseX, mouseY, button);
        }    }

    public void mouseRelease(double mouseX, double mouseY, int button) {
        for (Component component : components){
            component.mouseReleased(mouseX, mouseY, button);
        }
    }
    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}
