package org.adlin.simpleminecraftcheat.modules.settings;

public class BooleanSettings extends Settings{
    private boolean enabled;
    public BooleanSettings(String name , boolean defaultVisible){
        super(name);
        this.enabled = defaultVisible;
    }

    public void toggle(){
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
