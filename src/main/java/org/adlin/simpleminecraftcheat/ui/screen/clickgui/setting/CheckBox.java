package org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting;

import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.ModuleButton;
import org.adlin.simpleminecraftcheat.modules.settings.BooleanSettings;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;

import java.awt.*;

public class CheckBox extends Component{
    public BooleanSettings boolSet;
    public CheckBox(Settings settings, ModuleButton parent, int offset) {
        super(settings, parent, offset);
        this.boolSet = (BooleanSettings) settings;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int offsetY = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);
        context.fill(parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset+ offset+ parent.parent.height , new Color(0 ,0 ,0 ,160).getRGB());
        context.drawText(mc.textRenderer , boolSet.getName() + ": "+ boolSet.isEnabled() , parent.parent.x + offsetY , parent.parent.y + parent.offset + offset + offsetY , -1, true);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX , mouseY) && button == 0){
            boolSet.toggle();
        }
        super.mouseClicked(mouseX, mouseY, button);
    }
}
