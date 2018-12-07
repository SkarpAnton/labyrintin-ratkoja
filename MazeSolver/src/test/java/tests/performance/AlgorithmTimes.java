package tests.performance;

public class AlgorithmTimes {

    private double kruskalTime;
    private double aStarTime;
    private double bfsTime;

    public double getKruskalTime() {
        return kruskalTime;
    }

    public void setKruskalTime(double kruskalTime) {
        this.kruskalTime = kruskalTime;
    }

    public double getaStarTime() {
        return aStarTime;
    }

    public void setaStarTime(double aStarTime) {
        this.aStarTime = aStarTime;
    }

    public double getBfsTime() {
        return bfsTime;
    }

    public void setBfsTime(double bfsTime) {
        this.bfsTime = bfsTime;
    }

    @Override
    public String toString() {
        return "AlgorithmTimes{" + "kruskalTime=" + kruskalTime + ", aStarTime=" + aStarTime + ", bfsTime=" + bfsTime + '}';
    }

}
