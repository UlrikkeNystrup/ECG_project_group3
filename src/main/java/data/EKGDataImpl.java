package data;

public class EKGDataImpl implements EKGData {
    private double voltage;
    private double time;

    public EKGDataImpl(double voltage, double time) {
        this.time=time;
        this.voltage=voltage;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public void setTime(double time) {
        this.time = time;
    }
}
