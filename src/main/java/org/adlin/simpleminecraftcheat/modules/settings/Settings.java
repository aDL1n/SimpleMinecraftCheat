package org.adlin.simpleminecraftcheat.modules.settings;

public class Settings {
    private final String name;
    private boolean visible = true;

    public Settings(String name){
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }
}
