package data.dao;

import data.MySqlConnection;
import data.dto.EcgDtoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcgDaoImpl implements EcgDao {

    // denne metode bruger vi til at gemme EKG data i tabellen EcgData i databasen
    //getConnection() er implementeret i klassen MySQLConnection, getConnection() er en klassemetode, skal man ikke oprette et objekt for at kalde metoden
    @Override
    public void save(List <EcgDtoImpl> ecgDtoList) {
        try {
            Connection connection= MySqlConnection.getConnection();
            // connection.setAutoCommit(false); //måske unødvendigt med denne linje
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ecgData(patientId, time, voltage) VALUES (?,?,?)");

            for (EcgDtoImpl ecgDtoImpl: ecgDtoList ) {
                preparedStatement.setString(1, ecgDtoImpl.getPatientId());
                preparedStatement.setTimestamp(2, ecgDtoImpl.getTime());
                preparedStatement.setDouble(3, ecgDtoImpl.getVoltage());
                preparedStatement.addBatch();
            }
                preparedStatement.executeBatch();
                //connection.commit(); //nok unødvendigt
            }catch (SQLException e) {
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
