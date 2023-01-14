package com.orh.client.commands;

import com.orh.client.ORH;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class CommandManager implements ORH {

    private HashMap<String, Command> hashMap = new HashMap<>();
    public CommandManager() {
        MinecraftForge.EVENT_BUS.register(this);
        register(new Test());
    }

    @SubscribeEvent
    public void onChatReceivedEvent(ClientChatReceivedEvent event) {
        if (!event.getMessage().getUnformattedText().startsWith(ORH_COMMAND_PREFIX)) return;
        if (hashMap.containsKey(event.getMessage().getUnformattedText().replace(".",""))) {
            event.setCanceled(true);
            Command command = getCommandByName(event.getMessage().getUnformattedText().replace(".",""));
            String[] args = event.getMessage().getUnformattedText().split(" ");
            command.execute(args);
        } else {
            event.setCanceled(true);
        }
    }

    private Command getCommandByName(String name) {
        return hashMap.get(name);
    }
    private void register(Command command) {
        hashMap.put(command.getName(), command);
    }
}
