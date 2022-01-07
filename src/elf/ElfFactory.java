package elf;

import enums.ElvesType;

public final class ElfFactory {
    private ElfFactory() {
    }

    public static Elf getHelp(final ElvesType type) {
        return switch (type) {
            case YELLOW -> new Yellow();
            case BLACK -> new Black();
            case PINK -> new Pink();
            case WHITE -> new White();
        };
    }
}
