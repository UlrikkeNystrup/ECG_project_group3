package data.dto;

import java.sql.Timestamp;

public class EcgDtoImpl implements EcgDto {
    //denne klasse har erstattet vores tidligere klasse EcgDataImpl
    private String patient_ID;
    private Timestamp time;
    private double voltage;

/*
    public EcgDtoImpl(String patient_ID, Timestamp time, double voltage) {
        this.patient_ID = patient_ID;
        this.time = time;
        this.voltage = voltage;
    }
bruger vi denne konstruktør?
 */

    @Override
    public String getId() {return patient_ID;}

    @Override
    public void setId(String id) {
        this.patient_ID = id;
    }

   @Override
    public double getVoltage() {return voltage;}

   @Override
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public Timestamp getTime() {
        return time;
    }

    @Override
    public void setTime(Timestamp time) {
        this.time = time;
    }
}

