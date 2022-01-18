package elf;

import fileio.ChildInput;

public abstract class Elf {
    /**
     * The elf updates the child's data
     *
     * @param child the child which will be updated
     */
    public abstract void help(ChildInput child);
}
