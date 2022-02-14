package tanf;

public class TemperatureData {
    private int mxt;
    private int mnt;


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

    public int getDifference(){
        return Math.abs(this.getMxt() - this.getMnt());
    }
}
