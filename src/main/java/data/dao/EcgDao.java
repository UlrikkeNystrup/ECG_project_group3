package data.dao;

import data.dto.EcgDtoImpl;

import java.sql.Timestamp;
import java.util.List;

public interface EcgDao {
    void save(EcgDtoImpl ecgDto);
    List<EcgDtoImpl> load(Timestamp time);
}
