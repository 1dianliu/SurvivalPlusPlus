package dev.anvilcraft.rg.survival;

import dev.anvilcraft.rg.RollingGateCategories;
import dev.anvilcraft.rg.api.Rule;

public class SurvivalPlusPlusServerRules {
    @Rule(
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.SURVIVAL
        }
    )
    public static boolean broadcastDeathPosition = false;
}
