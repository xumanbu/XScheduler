package org.example.dagmanger.commond;

import org.example.dagmanger.commond.Command;

public class ShellCommand implements Command {

    private String script;
    public ShellCommand(String script) {
        this.script = script;
    }

    @Override
    public void run() {
        // 执行script
    }
}
