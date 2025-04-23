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

    @Rule(
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.CREATIVE
        }
    )
    public static boolean simpleInGameCalculator = false;

    //创造玩家无碰撞检测
    @Rule(
        allowed = {"true", "false"},
        categories = {
            SurvivalPlusPlus.MOD_ID,
            RollingGateCategories.CREATIVE
        }
    )
    public static boolean creativeNoClip = false;
}
