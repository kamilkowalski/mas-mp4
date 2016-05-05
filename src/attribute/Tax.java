package attribute;

public class Tax {
    private String name;
    private int percentage;

    private static final int MAX_PERCENTAGE = 100;
    private static final int MIN_PERCENTAGE = 0;

    public Tax(String name, int percentage) throws Exception {
        setName(name);
        setPercentage(percentage);
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) throws Exception {
        if (percentage > MAX_PERCENTAGE) {
            throw new Exception("Podatek nie może przekraczać 100%");
        }

        if (percentage <= MIN_PERCENTAGE) {
            throw new Exception("Podatek musi być dodatni");
        }

        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
