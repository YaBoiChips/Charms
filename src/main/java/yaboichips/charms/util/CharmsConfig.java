package yaboichips.charms.util;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CharmsConfig {
    private static final ForgeConfigSpec CONFIG_SPEC;
    private static final CharmsConfig INSTANCE;

    static {
        final Pair<CharmsConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CharmsConfig::new);
        CONFIG_SPEC = specPair.getRight();
        INSTANCE = specPair.getLeft();
    }

    private final ForgeConfigSpec.IntValue charmSlots;
    private final ForgeConfigSpec.BooleanValue allowSaturationCharm;
    private final ForgeConfigSpec.BooleanValue allowSpeedCharm;
    private final ForgeConfigSpec.BooleanValue allowSpeed2Charm;
    private final ForgeConfigSpec.BooleanValue allowHasteCharm;
    private final ForgeConfigSpec.BooleanValue allowHaste2Charm;
    private final ForgeConfigSpec.BooleanValue allowStrengthCharm;
    private final ForgeConfigSpec.BooleanValue allowStrength2Charm;
    private final ForgeConfigSpec.BooleanValue allowAbsorptionCharm;
    private final ForgeConfigSpec.BooleanValue allowAbsorption2Charm;
    private final ForgeConfigSpec.BooleanValue allowGlowingCharm;
    private final ForgeConfigSpec.BooleanValue allowDolphinCharm;
    private final ForgeConfigSpec.BooleanValue allowBlindnessCharm;
    private final ForgeConfigSpec.BooleanValue allowNauseaCharm;
    private final ForgeConfigSpec.BooleanValue allowInvisCharm;
    private final ForgeConfigSpec.BooleanValue allowLuckCharm;
    private final ForgeConfigSpec.BooleanValue allowLevitationCharm;
    private final ForgeConfigSpec.BooleanValue allowSlownessCharm;
    private final ForgeConfigSpec.BooleanValue allowSlowFallingCharm;
    private final ForgeConfigSpec.BooleanValue allowFireResistanceCharm;
    private final ForgeConfigSpec.BooleanValue allowWaterBreathingCharm;
    private final ForgeConfigSpec.BooleanValue allowMiningFatigueCharm;
    private final ForgeConfigSpec.BooleanValue allowNightVisionCharm;
    private final ForgeConfigSpec.BooleanValue allowResistanceCharm;
    private final ForgeConfigSpec.BooleanValue allowResistance2Charm;
    private final ForgeConfigSpec.BooleanValue allowJumpCharm;
    private final ForgeConfigSpec.BooleanValue allowJump2Charm;
    private final ForgeConfigSpec.BooleanValue allowSpiderCharm;
    private final ForgeConfigSpec.BooleanValue allowFallCharm;
    private final ForgeConfigSpec.BooleanValue allowBounceCharm;
    private final ForgeConfigSpec.BooleanValue allowSteelToedCharm;

    public CharmsConfig(ForgeConfigSpec.Builder builder) {
        charmSlots = builder.defineInRange("Charm Slots", 2, 1, 26);
        builder.push("CHARMS CONFIG [NOT FUNCTIONAL DON'T USE]");
        allowSaturationCharm = builder.define("allowSaturationCharm", true);
        allowSpeedCharm = builder.define("allowSpeedCharm", true);
        allowSpeed2Charm = builder.define("allowSpeed2Charm", true);
        allowHasteCharm = builder.define("allowHasteCharm", true);
        allowHaste2Charm = builder.define("allowHaste2Charm", true);
        allowStrengthCharm = builder.define("allowStrengthCharm", true);
        allowStrength2Charm = builder.define("allowStrength2Charm", true);
        allowAbsorptionCharm = builder.define("allowAbsorptionCharm", true);
        allowAbsorption2Charm = builder.define("allowAbsorption2Charm", true);
        allowGlowingCharm = builder.define("allowGlowingCharm", true);
        allowDolphinCharm = builder.define("allowDolphinCharm", true);
        allowBlindnessCharm = builder.define("allowBlindnessCharm", true);
        allowNauseaCharm = builder.define("allowNauseaCharm", true);
        allowInvisCharm = builder.define("allowInvisCharm", true);
        allowLuckCharm = builder.define("allowLuckCharm", true);
        allowLevitationCharm = builder.define("allowLevitationCharm", true);
        allowSlownessCharm = builder.define("allowSlownessCharm", true);
        allowSlowFallingCharm = builder.define("allowSlowFallingCharm", true);
        allowFireResistanceCharm = builder.define("allowFireResistanceCharm", true);
        allowWaterBreathingCharm = builder.define("allowWaterBreathingCharm", true);
        allowMiningFatigueCharm = builder.define("allowMiningFatigueCharm", true);
        allowNightVisionCharm = builder.define("allowNightVisionCharm", true);
        allowResistanceCharm = builder.define("allowResistanceCharm", true);
        allowResistance2Charm = builder.define("allowResistance2Charm", true);
        allowJumpCharm = builder.define("allowJumpCharm", true);
        allowJump2Charm = builder.define("allowJump2Charm", true);
        allowSpiderCharm = builder.define("allowSpiderCharm", true);
        allowFallCharm = builder.define("allowFallCharm", true);
        allowBounceCharm = builder.define("allowBounceCharm", true);
        allowSteelToedCharm = builder.define("allowSteelToedCharm", true);
        builder.pop();

    }

    public static ForgeConfigSpec getConfigSpec() {
        return CONFIG_SPEC;
    }

    public static CharmsConfig getInstance() {
        return INSTANCE;
    }

    public int charmSlots() {
        return charmSlots.get();
    }

    public boolean allowSaturationCharm() {
        return allowSaturationCharm.get();
    }

    public boolean allowSpeedCharm() {
        return allowSpeedCharm.get();
    }

    public boolean allowSpeed2Charm() {
        return allowSpeed2Charm.get();
    }

    public boolean allowHasteCharm() {
        return allowHasteCharm.get();
    }

    public boolean allowHaste2Charm() {
        return allowHaste2Charm.get();
    }

    public boolean allowStrengthCharm() {
        return allowStrengthCharm.get();
    }

    public boolean allowStrength2Charm() {
        return allowStrength2Charm.get();
    }

    public boolean allowAbsorptionCharm() {
        return allowAbsorptionCharm.get();
    }

    public boolean allowAbsorption2Charm() {
        return allowAbsorption2Charm.get();
    }

    public boolean allowGlowingCharm() {
        return allowGlowingCharm.get();
    }

    public boolean allowDolphinCharm() {
        return allowDolphinCharm.get();
    }

    public boolean allowBlindnessCharm() {
        return allowBlindnessCharm.get();
    }

    public boolean allowNauseaCharm() {
        return allowNauseaCharm.get();
    }

    public boolean allowInvisCharm() {
        return allowInvisCharm.get();
    }

    public boolean allowLuckCharm() {
        return allowLuckCharm.get();
    }

    public boolean allowLevitationCharm() {
        return allowLevitationCharm.get();
    }

    public boolean allowSlownessCharm() {
        return allowSlownessCharm.get();
    }

    public boolean allowSlowFallingCharm() {
        return allowSlowFallingCharm.get();
    }

    public boolean allowFireResistanceCharm() {
        return allowFireResistanceCharm.get();
    }

    public boolean allowWaterBreathingCharm() {
        return allowWaterBreathingCharm.get();
    }

    public boolean allowMiningFatigueCharm() {
        return allowMiningFatigueCharm.get();
    }

    public boolean allowNightVisionCharm() {
        return allowNightVisionCharm.get();
    }

    public boolean allowResistanceCharm() {
        return allowResistanceCharm.get();
    }

    public boolean allowResistance2Charm() {
        return allowResistance2Charm.get();
    }

    public boolean allowJumpCharm() {
        return allowJumpCharm.get();
    }

    public boolean allowJump2Charm() {
        return allowJump2Charm.get();
    }

    public boolean allowSpiderCharm() {
        return allowSpiderCharm.get();
    }

    public boolean allowFallCharm() {
        return allowFallCharm.get();
    }

    public boolean allowBounceCharm() {
        return allowBounceCharm.get();
    }

    public boolean allowSteelToedCharm() {
        return allowSteelToedCharm.get();
    }
}
