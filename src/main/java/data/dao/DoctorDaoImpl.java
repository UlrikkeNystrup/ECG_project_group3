//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data.dao;

import data.MySqlConnection;
import data.dto.DoctorDtoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    DoctorDtoImpl doctorDto = new DoctorDtoImpl();

    @Override
    public void save(DoctorDtoImpl doctorDtoImpl) {
        try {
            Connection connection= MySqlConnection.getConnection();
            //connection.setAutoCommit(false); //overflødig fordi vi kun laver én type forespørgsel

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO doctors (authId, firstName, lastName) VALUES (?,?,?)");

            preparedStatement.setString(1, doctorDto.getAuthId());
            preparedStatement.setString(2, doctorDto.getFirstName());
            preparedStatement.setString(3, doctorDto.getLastName());

            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(DoctorDtoImpl doctorDtoImpl) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<DoctorDtoImpl> getAll() {
        return null;
    }

    @Override
    public DoctorDtoImpl get(String id) {
        return null;
    }
}


