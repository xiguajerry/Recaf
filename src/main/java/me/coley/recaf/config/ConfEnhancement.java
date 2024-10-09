package me.coley.recaf.config;

public class ConfEnhancement extends Config {
    @Conf("enhancement.showmixintargets")
    public boolean showMixinTargets = true;

    @Conf("enhancement.showfabricentrypoints")
    public boolean showFabricEntrypoints = true;

    @Conf("enhancement.asmifier.ignoreframes")
    public boolean asmifierIgnoreFrames = false;

    @Conf("enhancement.gruntdsl.ignorelines")
    public boolean gruntDSLIgnoreLines = true;

    @Conf("enhancement.gruntdsl.ignoreframes")
    public boolean gruntDSLIgnoreFrames = false;

    @Conf("enhancement.gruntdsl.ignoremaxs")
    public boolean gruntDSLIgnoreMaxs = false;

    @Conf("enhancement.gruntdsl.ignorelocalvariable")
    public boolean gruntDSLIgnoreLocalVariable = false;

    @Conf("enhancement.genesis.imports")
    public boolean genesisDSLImports = false;

    ConfEnhancement() {
        super("enhancement");
    }
}
