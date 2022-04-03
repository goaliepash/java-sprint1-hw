public class Converter {

    private static final double KILOMETERS_PER_STEP = 0.00075;
    private static final double KILOCALORIES_PER_STEP = 0.05;

    public double calculateDistance(int steps) {
        return KILOMETERS_PER_STEP * steps;
    }

    public double calculateKilocalories(int steps) {
        return KILOCALORIES_PER_STEP * steps;
    }
}