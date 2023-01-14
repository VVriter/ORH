package com.orh.client.commands;

@CommandAnnotation(
        name = "test",
        min_args = 0,
        max_args = 0
)
public class Test extends Command {
    @Override
    public void execute(String[] args) {
        super.execute(args);
        notify("HELLO!");
    }
}
