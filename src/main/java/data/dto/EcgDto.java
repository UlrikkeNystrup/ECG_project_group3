//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data.dto;

import java.sql.Timestamp;

public interface EcgDto {
    void setPatientId(String patientId);
    String getPatientId();
    void setVoltage(double voltage);
    double getVoltage();
    void setTime(Timestamp time);
    Timestamp getTimeStamp();
}
