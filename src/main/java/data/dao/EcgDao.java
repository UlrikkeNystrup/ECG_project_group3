package data.dao;

import data.dto.EcgDto;

import java.sql.Timestamp;
import java.util.List;

public interface EcgDao {
    void save(EcgDto ecgDto);
    List<EcgDto> load(Timestamp time);
}
