package elf;

import fileio.ChildInput;

final class Black extends Elf {
    @Override
    public void help(ChildInput child) {
        double assignedBudget = child.getAssignedBudget();
        double newAssignedBudget = assignedBudget - assignedBudget * 30 / 100;
        child.setAssignedBudget(newAssignedBudget);
    }
}
