package data.dao;

import data.dto.DoctorDtoImpl;

import java.util.List;

public interface DoctorDao {
    //vi bruger ikke dette interface endnu
    List<DoctorDtoImpl> getAll();
    DoctorDtoImpl get(String id);
    void save(DoctorDtoImpl doctorDtoImpl);
    void update(DoctorDtoImpl doctorDtoImpl);
    void delete(String id);
}
