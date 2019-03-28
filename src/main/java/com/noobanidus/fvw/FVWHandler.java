package com.noobanidus.fvw;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class FVWHandler {
    public static void setLevelType () {
        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

        if (server instanceof DedicatedServer) {
            DedicatedServer serverDedicated = (DedicatedServer) server;
            serverDedicated.setProperty("level-type", "voidworld");
            ForceVoidWorld.LOG.info("Forced level-type to be `voidworld`.");
        }
    }
}
