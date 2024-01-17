package org.adlin.simpleminecraftcheat.ui.screen.clickgui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.adlin.simpleminecraftcheat.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends Screen {
    public static final ClickGUI INSTANCE = new ClickGUI();

    private final List<CategoryFrame> frames;
    private ClickGUI() {
        super(Text.literal("Click GUI"));
        frames = new ArrayList<>();

        int offset = 20;
        for(Module.Category category: Module.Category.values()){
            frames.add(new CategoryFrame(30, offset, 100, 20, category));
            offset += 31;
        }

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        for (CategoryFrame frame: frames){
            frame.render(context , mouseX , mouseY , delta);
            frame.updatePosition(mouseX,mouseY);
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (CategoryFrame frame: frames){
            frame.mouseClicked(mouseX , mouseY , button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for(CategoryFrame frame : frames){
            frame.mouseRelease(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
