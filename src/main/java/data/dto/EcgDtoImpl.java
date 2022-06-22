package data.dto;

import java.sql.Timestamp;

public class EcgDtoImpl implements EcgDto {
    //denne klasse har erstattet vores tidligere klasse EcgDataImpl
    //databærende klasse, svarer til tabellen ecgData
    //bruges til at transportere data hele vejen igennem applikationen
    private String patientId; //attributterne svarer
    private Timestamp time;
    private double voltage;

/*
    public EcgDtoImpl(String patient_ID, Timestamp time, double voltage) {
        this.patient_ID = patient_ID;
        this.time = time;
        this.voltage = voltage;
    }
 vi bruger ikke denne konstruktør?
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
    public Timestamp getTimeStamp() {
        return time;
    }

    @Override
    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EcgDtoImpl{" +
                "patientId='" + patientId + '\'' +
                ", time=" + time +
                ", voltage=" + voltage +
                '}';
    }
}

