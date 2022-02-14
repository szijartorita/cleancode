package tanf;

public class TemperatureData {
    private int day;
    private int mxt;
    private int mnt;
    private int minMaxDiff;

    public int getMxt() {
        return mxt;
    }

    public void setMxt(int mxt) {
        this.mxt = mxt;
    }

    public int getMnt() {
        return mnt;
    }

    public void setMnt(int mnt) {
        this.mnt = mnt;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMinMaxDiff() {
        return minMaxDiff;
    }

    public void setMinMaxDiff(int minMaxDiff) {
        this.minMaxDiff = minMaxDiff;
    }

    public int getDifference() {
        return this.getMxt() - this.getMnt();
    }
}
