package net.ympl.mineminenomiaddontemplate;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.ympl.mineminenomiaddontemplate.init.ModAbilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mineminenomiaddontemplate")
public class MineMineNoMiAddonTemplate {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mineminenomiaddontemplate";

    public MineMineNoMiAddonTemplate() {
        ModAbilities.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
