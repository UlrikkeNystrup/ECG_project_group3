package data.dao;

import data.MySqlConnection;
import data.dto.EcgDtoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcgDaoImpl implements EcgDao {

    //@Override
  //  public void save(EcgDtoImpl ecgDto) {
        // denne metode bruger vi til at gemme EKG data i tabellen EcgData i databasen
        /*Connection connection= MySqlConnection.getConnection(); vi kalder getConnction på MySQLConnection, som vi ikke behøver at oprette objekt for
        Fordi vi har importeret: import data.MySqlConnection;, getConnetion metoden returnerer et connection objekt hvilket bliver gemt som
        Connection objekt her inde og navngivet connection */

    @Override
    public void save(List <EcgDtoImpl> ecgDtoList) {
        try {
            Connection connection= MySqlConnection.getConnection();
            //connection.setAutoCommit(false); //overflødig fordi vi kun laver én type forespørgsel

            //System.out.println("Start: " + System.currentTimeMillis());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ecgData(patientId, time, voltage) VALUES (?,?,?)");

            for (EcgDtoImpl ecgDtoImpl: ecgDtoList ) {
                preparedStatement.setString(1, ecgDtoImpl.getPatientId());
                preparedStatement.setTimestamp(2, ecgDtoImpl.getTime());
                preparedStatement.setDouble(3, ecgDtoImpl.getVoltage());
                preparedStatement.addBatch();

                //preparedStatement.execute();
            }
                preparedStatement.executeBatch();
                //connection.commit(); //nok unødvendigt
                //System.out.println("Batch indsat: " + System.currentTimeMillis());

            }catch (SQLException e) {
                 e.printStackTrace();
            }

            // preparedStatement.close(); ???


    }

    @Override
    public List<EcgDtoImpl> load(Timestamp time) {
        //vi har ikke anvendt denne metode endnu, men skal bruges til at hente lagret EKG data fra databasen
        List<EcgDtoImpl> data = new ArrayList<>();
        Connection connection = MySqlConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ecgData WHERE time > ? ");
            preparedStatement.setTimestamp(2,time);
            ResultSet resultSet = preparedStatement.executeQuery();
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
