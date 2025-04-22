package dev.anvilcraft.rg.survival;

import com.mojang.logging.LogUtils;
import dev.anvilcraft.rg.api.RGAdditional;
import dev.anvilcraft.rg.api.server.ServerRGRuleManager;
import dev.anvilcraft.rg.api.server.TranslationUtil;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(SurvivalPlusPlus.MOD_ID)
public class SurvivalPlusPlus implements RGAdditional {
    public static final String MOD_ID = "survival_plus_plus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SurvivalPlusPlus(IEventBus modEventBus, @NotNull ModContainer modContainer) {
        modContainer.registerExtensionPoint(RGAdditional.class, this);
    }

    @Override
    public void loadServerRules(@NotNull ServerRGRuleManager manager) {
        manager.register(SurvivalPlusPlusServerRules.class);
        TranslationUtil.loadLanguage(SurvivalPlusPlus.class, SurvivalPlusPlus.MOD_ID, "en_us");
        TranslationUtil.loadLanguage(SurvivalPlusPlus.class, SurvivalPlusPlus.MOD_ID, "zh_cn");
    }
}
