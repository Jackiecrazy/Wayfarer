package jackiecrazy.wayfarer.mixin;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.Map;

@Mixin(TemplateManager.class)
public abstract class TemplateManagerMixin {

    @Shadow
    @Final
    @Mutable
    private Map<ResourceLocation, Template> templates;

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void init(CallbackInfo info) {
        templates = Collections.synchronizedMap(templates);
    }

}