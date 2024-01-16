package org.adlin.simpleminecraftcheat.modules;

import net.minecraft.client.MinecraftClient;
import org.adlin.simpleminecraftcheat.modules.settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class Module {

    private String name;
    private String displayName;
    private String description;
    private int key;
    private boolean enabled;
    private final Category category;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    private List<Settings> settings = new ArrayList<>();

    public Module(String name, String displayName,  String description, boolean enabled , Category category) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.category = category;
        this.enabled = enabled;
    }

    public void toggle(){
        this.enabled = !this.enabled;
        if(enabled) onEnable();
        else onDisable();
    }

    public void onDisable() {

    }

    public void onEnable() {
        
    }

    public void onTick(){

    }

    public void onTickDisable(){

    }

    public enum Category {
        COMBAT("Combat"),
        MOVEMENT("Movement"),
        RENDER("Render"),
        EXPLOIT("Exploit"),
        WORLD("World");

        public String name;

        private Category(String name){
            this.name = name;
        }

    }

    public List<Settings> getSettings() {
        return settings;
    }

    public void addSettings(Settings settings){
        this.settings.add(settings);
    }

    public void addSettings(Settings... settings){
        for(Settings setting : settings) addSettings(setting);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if(enabled) onEnable();
        else onDisable();
    }

    public Category getCategory() {
        return category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

