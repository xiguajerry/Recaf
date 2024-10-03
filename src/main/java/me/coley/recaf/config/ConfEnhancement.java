package me.coley.recaf.config;

public class ConfEnhancement extends Config {
    @Conf("enhancement.showmixintargets")
    public boolean showMixinTargets = true;

    @Conf("enhancement.showfabricentrypoints")
    public boolean showFabricEntrypoints = true;

    ConfEnhancement() {
        super("enhancement");
    }
}
