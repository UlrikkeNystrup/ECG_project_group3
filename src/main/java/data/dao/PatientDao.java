package data.dao;
import data.dto.PatientDtoImpl;

import java.util.List;

public interface PatientDao {
    //vi bruger ikke dette interface endnu
    List<PatientDtoImpl> getAll();
    PatientDtoImpl get(String patientId);
    void save(PatientDtoImpl patientDtoImpl);
    void update(PatientDtoImpl patientDtoImpl);
    void delete(String patientId);
}
