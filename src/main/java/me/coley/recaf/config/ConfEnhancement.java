package me.coley.recaf.config;

public class ConfEnhancement extends Config {
    @Conf("enhancement.showmixintargets")
    public boolean showMixinTargets = true;

    @Conf("enhancement.showfabricentrypoints")
    public boolean showFabricEntrypoints = true;

    @Conf("enhancement.asmifier.ignoreframes")
    public boolean asmifierIgnoreFrames = false;

    ConfEnhancement() {
        super("enhancement");
    }
}
