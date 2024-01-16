package org.adlin.simpleminecraftcheat.modules;

import org.adlin.simpleminecraftcheat.modules.settings.BooleanSettings;
import org.adlin.simpleminecraftcheat.modules.settings.ModeSettings;
import org.adlin.simpleminecraftcheat.modules.settings.NumberSettings;

public class TestModule extends Module {
    public NumberSettings numberSettings = new NumberSettings("Speed" , 0.02 , 2 , 0.1 , 0.01);
    public BooleanSettings booleanSettings = new BooleanSettings("Test" , true);
    public ModeSettings modeSettings = new ModeSettings("test" , "1" , "1" , "2" , "3");
    public TestModule() {
        super("test", "test", "test", false, Category.COMBAT);
        addSettings(modeSettings , booleanSettings , numberSettings);
    }
}
