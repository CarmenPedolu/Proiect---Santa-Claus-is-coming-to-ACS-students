package updates;

import enums.UpdatesType;

public final class UpdatesFactory {

    private UpdatesFactory() {
    }

    /**
     * Return the class for the data which should be updated
     *
     * @param type data type which should pe updated
     * @return the class which updates the data
     */
    public static Changes getUpdate(final UpdatesType type) {
        return switch (type) {
            case Child -> new ChildUpdates();
            case NewGiftsChildren -> new NewGiftsChildrenUpdates();
            case SantaBudget -> new SantaBudgetUpdate();
        };
    }
}
