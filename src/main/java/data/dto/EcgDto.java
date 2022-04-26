package data.dto;

import java.sql.Timestamp;

public interface EcgDto {
    void setId(String id);
    String getId();
    void setVoltage(double voltage);
    double getVoltage();
    void setTime(Timestamp time);
    Timestamp getTime();
}
