package com.orh.client;

import com.orh.client.commands.CommandManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MainLoader.MODID, name = MainLoader.NAME, version = MainLoader.VERSION)
public class MainLoader
{
    public static final String MODID = "orh";
    public static final String NAME = "ORH";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        CommandManager commandManager = new CommandManager();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Заканчиваем загружать ORH");
    }
}
