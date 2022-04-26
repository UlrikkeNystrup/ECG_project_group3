package data.dto;

import java.sql.Timestamp;

public class EcgDto {
    //skal denne klasse erstatte EcgDataImpl og dermed implementerer EcgData interfacet, som så også skal indeholde setID() og getID()?
    //hvis tilfældet -> så fjern udkommenteringer på override
    private int patient_ID;
    private double voltage;
    private Timestamp time;

    // @Override
    public int getId() {return patient_ID;}

    // @Override
    public void setId(int id) {
        this.patient_ID = id;
    }

   // @Override
    public double getVoltage() {return voltage;}

   // @Override
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    // @Override
    public Timestamp getTime() {
        return time;
    }

   // @Override
    public void setTime(Timestamp time) {
        this.time = time;
    }
}