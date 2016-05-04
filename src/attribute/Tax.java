package attribute;

public class Tax {
    private String name;
    private int percentage;

    public Tax(String name, int percentage) throws Exception {
        setName(name);
        setPercentage(percentage);
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) throws Exception {
        if (percentage > 100) {
            throw new Exception("Podatek nie może przekraczać 100%");
        }

        if (percentage <= 0) {
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
