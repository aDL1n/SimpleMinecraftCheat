package org.adlin.simpleminecraftcheat.mixins;

import net.minecraft.client.Keyboard;
import org.adlin.simpleminecraftcheat.Client;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey" , at=@At("HEAD"))
    public void onKeyPress(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci){
        Client.INSTANCE.onKeyPress(key , action);
    }
}
