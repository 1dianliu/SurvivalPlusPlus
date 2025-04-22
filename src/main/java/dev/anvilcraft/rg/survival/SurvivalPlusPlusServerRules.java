package dev.anvilcraft.rg.survival;

import dev.anvilcraft.rg.RollingGateCategories;
import dev.anvilcraft.rg.api.RGValidator;
import dev.anvilcraft.rg.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SurvivalPlusPlusServerRules {
    public static class ViewDistanceValidator extends RGValidator.IntegerValidator {
        @Override
        public @NotNull Map.Entry<Integer, Integer> getRange() {
            return Map.entry(0, 32);
        }
    }

    @Rule(
        allowed = {"0", "12", "16", "32"},
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.CREATIVE
        },
        validator = ViewDistanceValidator.class
    )
    public static int viewDistance = 0;

    @Rule(
        allowed = {"0", "12", "16", "32"},
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.CREATIVE
        },
        validator = ViewDistanceValidator.class
    )
    public static int simulationDistance = 0;

    @Rule(
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.SURVIVAL
        }
    )
    public static boolean broadcastDeathPosition = false;
}
