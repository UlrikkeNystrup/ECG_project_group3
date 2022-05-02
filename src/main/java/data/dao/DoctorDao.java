package data.dao;

import data.dto.DoctorDto;

import java.util.List;

public interface DoctorDao {
    //vi bruger ikke dette interface endnu
    List<DoctorDto> getAll();
    DoctorDto get(String id);
    void save(DoctorDto doc);
    void update(DoctorDto doc);
    void delete(String id);
}
