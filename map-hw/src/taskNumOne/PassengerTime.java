package taskNumOne;

public class PassengerTime {
    private int morningTime;
    private int eveningTime;
    private int nightTime;

    public PassengerTime(int morningTime, int eveningTime, int nightTime) {
        this.morningTime = morningTime;
        this.eveningTime = eveningTime;
        this.nightTime = nightTime;
    }

    public void setMorningTime(int morningTime) {
        this.morningTime = morningTime;
    }

    public void setEveningTime(int eveningTime) {
        this.eveningTime = eveningTime;
    }

    public void setNightTime(int nightTime) {
        this.nightTime = nightTime;
    }

    public int getMorningTime() {
        return morningTime;
    }

    public int getEveningTime() {
        return eveningTime;
    }

    public int getNightTime() {
        return nightTime;
    }

    @Override
    public String toString() {
        return "PassengerTime{" +
                "morningTime=" + morningTime +
                ", eveningTime=" + eveningTime +
                ", nightTime=" + nightTime +
                '}';
    }
}