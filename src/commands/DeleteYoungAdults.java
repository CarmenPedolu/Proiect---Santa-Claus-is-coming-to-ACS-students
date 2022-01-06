package commands;

import common.Constants;
import fileio.ChildInput;
import fileio.Input;

import java.util.ArrayList;
import java.util.List;

public class DeleteYoungAdults implements Command {
    @Override
    public final void execute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();

        List<ChildInput> youngAdults = new ArrayList<>();
        for (ChildInput child : allChildren) {
            if (child.getAge() >= Constants.NINETEEN) {
                youngAdults.add(child);
            }
        }

        for (ChildInput child : youngAdults) {
            allChildren.remove(child);
        }
    }
}
