package org.adlin.simpleminecraftcheat.modules.COMBAT;

import org.adlin.simpleminecraftcheat.modules.Module;
import org.adlin.simpleminecraftcheat.modules.settings.BooleanSettings;
import org.adlin.simpleminecraftcheat.modules.settings.KeyBindSettings;
import org.adlin.simpleminecraftcheat.modules.settings.ModeSettings;
import org.adlin.simpleminecraftcheat.modules.settings.NumberSettings;
import org.lwjgl.glfw.GLFW;

public class FlightModule extends Module {

    public NumberSettings numberSettings = new NumberSettings("Speed" , 0.02 , 2 , 0.1 , 0.01);
    public BooleanSettings booleanSettings = new BooleanSettings("NoFallDamage" , true);
    public ModeSettings modeSettings = new ModeSettings("test" , "1" , "1" , "2" , "3");
    public FlightModule() {
        super("Flight" ,"Fly" ,"LOl" , false , Module.Category.COMBAT);
        addSettings(numberSettings , booleanSettings, modeSettings);
    }
    @Override
    public void onTick() {
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(numberSettings.getValueFloat());
        if(booleanSettings.isEnabled()) mc.player.fallDistance = 0;
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
