//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data.dao;

import data.dto.EcgDtoImpl;

import java.sql.Timestamp;
import java.util.List;

public interface EcgDao {
    //void save(EcgDtoImpl ecgDto);
    void save(List <EcgDtoImpl> ecgDtoList);
    List<EcgDtoImpl> load(Timestamp time);
}
