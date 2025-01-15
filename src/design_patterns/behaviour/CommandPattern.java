package design_patterns.behaviour;

import java.util.List;
import java.util.Stack;

public class CommandPattern {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new OnCommand(), new OffCommand());
        invoker.executeOn();
        invoker.executeOff();
        invoker.executeOn();
        invoker.executeOff();
        System.out.println(invoker.getPerformedCommands().toString());
        invoker.unExecuteOff();
        System.out.println(invoker.getPerformedCommands().toString());
        invoker.unExecuteOff();
        System.out.println(invoker.getPerformedCommands().toString());
        invoker.unExecuteOn();
        System.out.println(invoker.getPerformedCommands().toString());
        invoker.unExecuteOn();
        System.out.println(invoker.getPerformedCommands().toString());
    }
}

class Invoker {
    final Stack<ICommand> performedCommands;
    final ICommand on;
    final ICommand off;

    public Invoker(ICommand on, ICommand off) {
        this.performedCommands = new Stack<>();
        this.on = on;
        this.off = off;
    }

    public List<ICommand> getPerformedCommands() {
        return performedCommands;
    }

    void executeOn() {
        this.on.execute();
        performedCommands.push(on);
    }

    void executeOff() {
        this.off.execute();
        performedCommands.push(off);
    }

    void unExecuteOff() {
        if (!performedCommands.isEmpty() && performedCommands.peek() instanceof OffCommand) {
            this.off.unExecute();
            performedCommands.pop();
        }
    }

    void unExecuteOn() {
        if (!performedCommands.isEmpty() && performedCommands.peek() instanceof OnCommand) {
            this.on.unExecute();
            performedCommands.pop();
        }
    }
}

interface ICommand {
    void execute();

    void unExecute();
}

class OnCommand implements ICommand {
    String currentCommand;

    @Override
    public void execute() {
        currentCommand = "Execute : ON";
        System.out.println("Execute : ON");
    }

    @Override
    public void unExecute() {
        currentCommand = "UnExecute : ON";
        System.out.println("UnExecute : ON");
    }

    @Override
    public String toString() {
        return "OnCommand{" +
                "currentCommand='" + currentCommand + '\'' +
                '}';
    }
}

class OffCommand implements ICommand {
    String currentCommand;

    @Override
    public void execute() {
        currentCommand = "Execute : OFF";
        System.out.println("Execute : OFF");
    }

    @Override
    public void unExecute() {
        currentCommand = "UnExecute : OFF";
        System.out.println("UnExecute : OFF");
    }

    @Override
    public String toString() {
        return "OffCommand{" +
                "currentCommand='" + currentCommand + '\'' +
                '}';
    }
}
