package org.adlin.simpleminecraftcheat.modules.settings;

import java.util.Arrays;
import java.util.List;

public class ModeSettings extends Settings{
    private String mode;
    private final List<String> modes;
    private int index;

    public ModeSettings(String name, String defaultMode, String... modes) {
        super(name);
        this.modes = Arrays.asList(modes);
        this.mode = defaultMode;
        this.index = this.modes.indexOf(defaultMode);
    }

    public List<String> getModes() {
        return modes;
    }

    public void setMode(String mode) {
        this.mode = mode;
        this.index = modes.indexOf(mode);
    }

    public String getMode() {
        return mode;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.mode = modes.get(index);
    }

    public void cycle(){
        if(index < modes.size() - 1){
            index++;
            mode = modes.get(index);
        } else if (index >= modes.size() - 1) {
            index = 0;
            mode = modes.get(0);
        }
    }

    public boolean isMode(String mode){
        return this.mode.equals(mode);
    }
}
