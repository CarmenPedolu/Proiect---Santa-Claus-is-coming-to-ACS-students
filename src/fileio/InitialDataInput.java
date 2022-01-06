package fileio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class InitialDataInput {
    @JsonProperty("children")
    private List<ChildInput> children;
    @JsonProperty("santaGiftsList")
    private List<SantaGiftsInput> santaGifts;

    public InitialDataInput() {
    }

    public InitialDataInput(final List<ChildInput> children,
                            final List<SantaGiftsInput> santaGifts) {
        this.children = children;
        this.santaGifts = santaGifts;
    }

    public List<SantaGiftsInput> getSantaGifts() {
        return santaGifts;
    }

    public List<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(final List<ChildInput> children) {
        this.children = children;
    }
}
