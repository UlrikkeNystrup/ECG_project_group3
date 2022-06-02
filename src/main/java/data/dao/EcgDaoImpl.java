package data.dao;

import data.MySqlConnection;
import data.dto.EcgDtoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcgDaoImpl implements EcgDao {

    @Override
    public void save(EcgDtoImpl ecgDto) {
        // denne metode bruger vi til at gemme EKG data i tabellen EcgData i databasen
        Connection connection= MySqlConnection.getConnection();
        //getConnection() er implementeret i klassen MySQLConnection, getConnection() er en klassemetode, skal man ikke oprette et objekt for at kalde metoden
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ecgData(patientId, time, voltage) VALUES (?,?,?)");
            preparedStatement.setString(1,ecgDto.getPatientId());
            preparedStatement.setTimestamp(2,ecgDto.getTime());
            preparedStatement.setDouble(3,ecgDto.getVoltage());
            preparedStatement.execute(); //execute() eksekverer SQL forespørgslen
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EcgDtoImpl> load(Timestamp time) {
        //vi har ikke anvendt denne metode endnu, men skal bruges til at hente lagret EKG data fra databasen
        List<EcgDtoImpl> data = new ArrayList<>();
        Connection connection = MySqlConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ecgData WHERE time > ? ");
            preparedStatement.setTimestamp(2,time);
            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery() bruges, da vi vil hente data, returnerer et resultSet
            while(resultSet.next()){
                EcgDtoImpl ecgDto = new EcgDtoImpl();
                ecgDto.setPatientId(resultSet.getString("patientId"));
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
