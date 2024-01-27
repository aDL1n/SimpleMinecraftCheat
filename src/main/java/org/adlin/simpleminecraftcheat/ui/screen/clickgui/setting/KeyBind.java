package org.adlin.simpleminecraftcheat.ui.screen.clickgui.setting;

import net.minecraft.client.gui.DrawContext;
import org.adlin.simpleminecraftcheat.modules.ModuleButton;
import org.adlin.simpleminecraftcheat.modules.settings.KeyBindSettings;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;

import java.awt.*;

public class KeyBind extends Component {

    private final KeyBindSettings binding = (KeyBindSettings)settings;
    public boolean isBinding = false;

    public KeyBind(Settings settings, ModuleButton parent, int offset) {
        super(settings, parent, offset);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            binding.toggle();
            isBinding = true;
        }
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void keyPressed(int key) {
        if (isBinding) {
            parent.module.setKey(key);
            binding.setKey(key);
            isBinding = false;
        }
        if ((binding.getKey() == 256)) {
            parent.module.setKey(0);
            binding.setKey(0);
            isBinding = false;
        }
        if ((binding.getKey() == 259)) {
            parent.module.setKey(0);
            binding.setKey(0);
            isBinding = false;
        }
        super.keyPressed(key);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, 0x90000000);
        int offsetY = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);

        if (!isBinding) context.drawText(mc.textRenderer, "Keybind: " + binding.getKeyName(), parent.parent.x + offsetY, parent.parent.y + parent.offset + offset + offsetY, -1, true);
        if (isBinding) context.drawText(mc.textRenderer, "Binding...", parent.parent.x + offsetY, parent.parent.y + parent.offset + offset + offsetY, Color.yellow.getRGB(), true);
        super.render(context, mouseX, mouseY, delta);
    }
}