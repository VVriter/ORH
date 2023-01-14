package com.orh.client.commands;

import com.orh.client.ORH;
import net.minecraft.util.text.TextComponentString;

public class Command implements ORH {
    private String name;
    private String description;
    private String[] alies;
    private int max_args;
    private int min_args;

    public Command() {
        if (getClass().isAnnotationPresent(CommandAnnotation.class)) {
            CommandAnnotation annotation = getClass().getAnnotation(CommandAnnotation.class);
            this.name = annotation.name();
            this.description = annotation.description();
            this.alies = annotation.alies();
            this.max_args = annotation.max_args();
            this.min_args = annotation.min_args();
        }
    }

    public void execute(String[] args) {
        if (args.length > max_args || args.length < min_args) {
            error("Вы неправильно используете команду! Описание команды: " + getDescription());
            return;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void notify(String s) {
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(ORH_PREFIX + s));
    }

    public void error(String s) {
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(ORH_PREFIX + s));
    }

    public void warn(String s) {
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(ORH_PREFIX + s));
    }

}
