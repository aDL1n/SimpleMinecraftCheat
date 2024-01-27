package org.adlin.simpleminecraftcheat.modules.settings;

import org.lwjgl.glfw.GLFW;

public class KeyBindSettings extends Settings{
    private int key;
    private boolean enabled;

    public KeyBindSettings(String name, int defaultKey) {
        super(name);
        this.key = defaultKey;
    }
    public int getKey() {
        return key;
    }

    public String getKeyName(){
        return GLFW.glfwGetKeyName(key , GLFW.glfwGetKeyScancode(key));
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }
}
