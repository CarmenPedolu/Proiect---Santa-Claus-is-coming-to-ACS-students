package commands;

import fileio.ChildInput;
import fileio.Input;

import java.util.List;

public class IncreaseAge implements Command {
    @Override
    public final void execute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();

        for (ChildInput child : allChildren) {
            child.setAge(child.getAge() + 1);
        }
    }
}
