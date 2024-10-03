package me.coley.recaf.util.fabric;

public class FabricEntrypoints {
    public static final String MAIN_ENTRY = "net/fabricmc/api/ModInitializer";
    public static final String CLIENT_ENTRY = "net/fabricmc/api/ClientModInitializer";
    public static final String SERVER_ENTRY = "net/fabricmc/api/DedicatedServerModInitializer";
    public static final String PRELAUNCH_ENTRY = "net/fabricmc/loader/api/entrypoint/PreLaunchEntrypoint";

    public static String getEntrypointType(String interfaceName) {
        switch (interfaceName) {
            case MAIN_ENTRY: return "Main";
            case CLIENT_ENTRY: return "Client";
            case SERVER_ENTRY: return "DedicatedServer";
            case PRELAUNCH_ENTRY: return "PreLaunch";
            default: throw new IllegalArgumentException("Unknown entrypoint interface: " + interfaceName);
        }
    }

    public static boolean isEntrypointInterface(String interfaceName) {
        return interfaceName.equals(MAIN_ENTRY) || interfaceName.equals(CLIENT_ENTRY)
                || interfaceName.equals(SERVER_ENTRY) || interfaceName.equals(PRELAUNCH_ENTRY);
    }
}
