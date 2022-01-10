package elf;

import common.Constants;
import fileio.ChildInput;

final class Pink extends Elf {
    @Override
    public void help(final ChildInput child) {
        double budget = child.getAssignedBudget();
        double newAssignedBudget = budget + budget * Constants.THIRTY / Constants.HUNDRED;
        child.setAssignedBudget(newAssignedBudget);
    }
}
