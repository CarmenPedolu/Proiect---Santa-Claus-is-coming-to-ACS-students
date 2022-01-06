package updates;

import fileio.ChangesInput;
import fileio.Input;

final class SantaBudgetUpdate extends Changes {
    @Override
    public void update(final int nrRound) {
        Input input = Input.getInput();
        ChangesInput changes = input.getAnnualChanges().get(nrRound - 1);
        // Updates the Santa budget
        input.setSantaBudget(changes.getNewSantaBudget());
    }
}
