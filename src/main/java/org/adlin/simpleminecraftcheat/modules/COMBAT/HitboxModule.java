package org.adlin.simpleminecraftcheat.modules.COMBAT;

import org.adlin.simpleminecraftcheat.modules.Module;
import org.adlin.simpleminecraftcheat.modules.settings.NumberSettings;

public class HitboxModule extends Module {

    public NumberSettings numberSettings = new NumberSettings("Size" , 0.1 , 2 , 0.4 , 0.1);

    public HitboxModule() {
        super("Hitbox", "Hitbox", "", false, Category.COMBAT);
        addSettings(numberSettings);
    }

    @Override
    public void onTick() {
        setSize(isEnabled() ? numberSettings.getValueFloat() : 0.3f );
        super.onTick();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    public static double getSize() {
        return size;
    }

    public static void setSize(double size) {
        HitboxModule.size = size;
    }
    private static double size;
}
