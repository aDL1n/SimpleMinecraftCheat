package org.adlin.simpleminecraftcheat;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.adlin.simpleminecraftcheat.modules.Module;
import org.adlin.simpleminecraftcheat.modules.ModuleManager;
import org.adlin.simpleminecraftcheat.ui.screen.clickgui.ClickGUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;


public class Client implements ModInitializer {
	
	public static final Client INSTANCE = new Client();
	public final String VERSION = "0.4-alpha";
	public static Logger logger = LogManager.getLogger(Client.class);
	public final MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {

	}
	public String getVERSION() {
		return VERSION;
	}

	public void onKeyPress(int key, int action) {
		if(action == GLFW.GLFW_PRESS){
			for(Module module : ModuleManager.INSTANCE.getModules()){
				if(key == module.getKey()) {
					module.toggle();
				}
			}
			if(key == GLFW.GLFW_KEY_RIGHT_SHIFT) mc.setScreen(ClickGUI.INSTANCE);
		}
	}
	
	public void onTick() {
		if(mc.player != null){
			for(Module module : ModuleManager.INSTANCE.getModules()){
				if(!module.isEnabled()) module.onTickDisable();
				else module.onTick();
			}
		}
	}
}
