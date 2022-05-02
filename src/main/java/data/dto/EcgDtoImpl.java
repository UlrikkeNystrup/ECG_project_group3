package data.dto;

import java.sql.Timestamp;

public class EcgDtoImpl implements EcgDto {
    //denne klasse har erstattet vores tidligere klasse EcgDataImpl
    private String patientId;
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
    public String getPatientId() {return patientId;}

    @Override
    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

