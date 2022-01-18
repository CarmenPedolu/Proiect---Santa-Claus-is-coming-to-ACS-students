package elf;

import enums.ElvesType;

public final class ElfFactory {
    private ElfFactory() {
    }

    /**
     * Return the class for the modifies which should be done by the elf
     *
     * @param type elf type which will make the modifies
     * @return the class which updates the child
     */
    public static Elf getHelp(final ElvesType type) {
        return switch (type) {
            case YELLOW -> new Yellow();
            case BLACK -> new Black();
            case PINK -> new Pink();
            case WHITE -> new White();
        };
    }
}
