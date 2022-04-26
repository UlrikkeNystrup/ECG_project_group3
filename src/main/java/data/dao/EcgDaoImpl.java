package data.dao;

import data.MySqlConnection;
import data.dto.EcgDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcgDaoImpl implements EcgDao {

    @Override
    public void save(EcgDto ecgDto) {

        Connection connection= MySqlConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ecgData(time, voltage) VALUES (?,?)");
            preparedStatement.setString(1,ecgDto.getTime());
            preparedStatement.setDouble(2,ecgDto.getVoltage());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EcgDto> load(Timestamp time) {
        List<EcgDto> data = new ArrayList<>();
        Connection connection = MySqlConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ecgData WHERE time > ? ");
            preparedStatement.setTimestamp(1,time);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                EcgDto ecgDto = new EcgDto();
                ecgDto.setId(resultSet.getInt("patient_ID"));  //kan det laves om til VARCHAR, så det kan indeholde CPR-nummer + laves om i databasen
                ecgDto.setTime(resultSet.getTimestamp("time"));
                ecgDto.setVoltage(resultSet.getDouble("voltage"));
                data.add(ecgDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
