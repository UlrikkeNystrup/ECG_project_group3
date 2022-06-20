package data.dao;
import data.dto.PatientDtoImpl;

import java.util.List;

public interface PatientDao {
    //vi har ikke implementeret dette interface endnu
    //List<PatientDtoImpl> getAll();
    //PatientDtoImpl get(String patientId);

    void save(PatientDtoImpl patientDto);

    void update(PatientDtoImpl patientDtoImpl);
    void delete(String patientId);
}
