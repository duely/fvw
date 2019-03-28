package com.noobanidus.fvw;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(modid = ForceVoidWorld.MODID, name = ForceVoidWorld.MODNAME, version = ForceVoidWorld.VERSION)
public class ForceVoidWorld {
    public static final String MODID = "fvw";
    public static final String MODNAME = "ForceVoidWorld";
    public static final String VERSION = "GRADLE:VERSION";

    @SuppressWarnings("unused")
    public final static Logger LOG = LogManager.getLogger(MODID);

    @Mod.Instance(ForceVoidWorld.MODID)
    public static ForceVoidWorld instance;

    @SideOnly(Side.SERVER)
    @Mod.EventHandler
    public static void serverStarted(FMLServerStartedEvent event) {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        if (server == null || server.isSinglePlayer()) return;

        FVWHandler.setLevelType();
    }
}
