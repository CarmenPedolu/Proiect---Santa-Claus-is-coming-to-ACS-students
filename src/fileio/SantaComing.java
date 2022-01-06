package fileio;

import java.util.List;

public final class SantaComing {
    private List<AnnualChildren> annualChildren;

    private static final SantaComing ANNUALSANTA = new SantaComing();

    public static SantaComing getAnnualSanta() {
        return ANNUALSANTA;
    }

    private SantaComing() {
    }

    public List<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final List<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
