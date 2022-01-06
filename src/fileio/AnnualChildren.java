package fileio;

import java.util.List;

public final class AnnualChildren {
    private List<ChildOutput> children;

    public AnnualChildren(final List<ChildOutput> children) {
        this.children = children;
    }

    public List<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildOutput> children) {
        this.children = children;
    }

}
