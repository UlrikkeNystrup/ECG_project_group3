package data;

public class EcgDataImpl implements EcgData {
    private double voltage;
    private double time;

    public EcgDataImpl(double voltage, double time) {
        this.time=time;
        this.voltage=voltage;
    }
    //bruger vi denne konstruktør?

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
