package org.adlin.simpleminecraftcheat.modules;

import org.adlin.simpleminecraftcheat.modules.COMBAT.FlightModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        addModules();
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getEnabledModules() {
        List<Module> enabled = new ArrayList<>();
        for (Module module : modules) {
            if (module.isEnabled()) enabled.add(module);
        }
        return enabled;
    }

    public List<Module> getModulesInCategory(Module.Category category) {
        List<Module> categoryModules = new ArrayList<>();

        for (Module mod : modules) {
            if (mod.getCategory() == category) {
                categoryModules.add(mod);
            }
        }

        return categoryModules;
    }

    private void addModules(){
        modules.add(new FlightModule());
    }
}
