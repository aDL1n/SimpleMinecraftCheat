package org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting;

import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.ModuleButton;
import org.adlin.simpleminecraftcheat.modules.settings.NumberSettings;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Slider extends Component{

    public NumberSettings numSet;
    private boolean sliding = false;
    public Slider(Settings settings, ModuleButton parent, int offset) {
        super(settings, parent, offset);
        this.numSet = (NumberSettings) settings;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        int offsetY = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);
        double diff = Math.min(parent.parent.width, Math.max(0, mouseX - parent.parent.x));
        int renderWidth = (int) (parent.parent.width * (numSet.getValue() - numSet.getMin()) / (numSet.getMax() - numSet.getMin()));
        context.fill(parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + renderWidth, parent.parent.y + parent.offset+ offset+ parent.parent.height , Color.yellow.getRGB());
        context.drawText(mc.textRenderer , numSet.getName() + ": "+ roundToPlace(numSet.getValue(),2) , parent.parent.x + offsetY , parent.parent.y + parent.offset + offset + offsetY , -1, true);

        if (sliding) {
            if (diff == 0) {
                numSet.setValue(numSet.getMin());
            } else {
                numSet.setValue(roundToPlace((diff / parent.parent.width) * (numSet.getMax() - numSet.getMin()) + numSet.getMin(), 2));
            }
        }

        context.fill(parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset+ offset+ parent.parent.height , new Color(0 ,0 ,0 ,160).getRGB());
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX,mouseY)) sliding =true;
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        sliding = false;
        super.mouseReleased(mouseX, mouseY, button);
    }

    private double roundToPlace(double value, int place){
        if(place < 0){
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place , RoundingMode.HALF_UP);
        return  bd.doubleValue();
    }
}
