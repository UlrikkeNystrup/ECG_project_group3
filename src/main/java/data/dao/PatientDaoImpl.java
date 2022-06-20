package data.dao;

import data.MySqlConnection;
import data.dto.EcgDtoImpl;
import data.dto.PatientDtoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PatientDaoImpl implements PatientDao{
    PatientDtoImpl ptDto = new PatientDtoImpl();



    /*@Override
    public List<PatientDtoImpl> getAll() {
       // return null;
    }*/

    @Override
    public void save(PatientDtoImpl ptDto) {
        System.out.println(ptDto.getPatientId());
        try {
            Connection connection= MySqlConnection.getConnection();
            //connection.setAutoCommit(false); //overflødig fordi vi kun laver én type forespørgsel

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients (patientId, firstName, lastName, doctorId) VALUES (?,?,?,?)");
                //System.out.println(ptDto.getPatientId());
                preparedStatement.setString(1, ptDto.getPatientId());
                preparedStatement.setString(2, ptDto.getFirstName());
                preparedStatement.setString(3, ptDto.getLastName());
                preparedStatement.setString(4, ptDto.getDoctorId());
                preparedStatement.execute();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PatientDtoImpl patientDtoImpl) {

    }

    @Override
    public void delete(String patientId) {

    }
}
