package commands;

public final class RoundInvoker {
    public RoundInvoker() {
    }

    /**
     * Executes the commands for the rounds
     *
     * @param command which will be executed
     */
    public void execute(final Command command) {
        command.execute();
    }
}
