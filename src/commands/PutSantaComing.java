package commands;

import fileio.AnnualChildren;
import fileio.ChildInput;
import fileio.Input;
import fileio.SantaComing;
import fileio.ChildOutput;

import java.util.ArrayList;
import java.util.List;

public class PutSantaComing implements Command {
    private final List<AnnualChildren> santaCame;

    public PutSantaComing(final List<AnnualChildren> santaCame) {
        this.santaCame = santaCame;
    }

    @Override
    public final void execute() {
        Input input = Input.getInput();
        List<ChildInput> allChildren = input.getInitialData().getChildren();
        List<ChildOutput> childrenSantaCame = new ArrayList<>();
        for (ChildInput child : allChildren) {
            if (child.getAvgScore() != 0) {
                ChildOutput childOut = new ChildOutput(child);
                childrenSantaCame.add(childOut);
            }
        }
        AnnualChildren annualChildren = new AnnualChildren(childrenSantaCame);
        santaCame.add(annualChildren);
        SantaComing.getAnnualSanta().setAnnualChildren(santaCame);
    }
}
