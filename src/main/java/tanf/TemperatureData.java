package tanf;

public class TemperatureData {
    private int day;
    private int mxt;
    private int mnt;
    private int minMaxDiff;

    public TemperatureData(String[] temperatureLine) {
        this.day = parseTemperature(temperatureLine[0]);
        this.mnt = parseTemperature(temperatureLine[2]);
        this.mxt = parseTemperature(temperatureLine[1]);
        this.minMaxDiff = getDifference();
    }

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

    public int parseTemperature(String temperature){
        temperature = temperature.replaceAll("[^0-9.-]", "");
        return Integer.parseInt(temperature);
    }
}
