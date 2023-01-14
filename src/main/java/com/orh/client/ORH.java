package com.orh.client;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;

public interface ORH {
    Minecraft mc = Minecraft.getMinecraft();
    String ORH_PREFIX = ChatFormatting.LIGHT_PURPLE + "[ORH] " + ChatFormatting.RESET;
}
