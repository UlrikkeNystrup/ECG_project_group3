package gui;
import data.dao.PatientDaoImpl;
import data.dto.PatientDtoImpl;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
public class gui2Controller {

    PatientDtoImpl ptDto =new PatientDtoImpl();
    PatientDaoImpl ptDao = new PatientDaoImpl();

    public TextField text1;
    public TextField text2;
    public TextField text3;
    public TextField text4;

    public void savePtData(MouseEvent mouseEvent) {

        String ptId = text1.getText();
        String forName = text2.getText();
        String lastName = text3.getText();
        String doctorId = text4.getText();

        ptDto.setPatientId(ptId);
        ptDto.setFirstName(forName);
        ptDto.setLastName(lastName);
        ptDto.setDoctorId(doctorId);

        // tidligere konstruktør: PatientDtoImpl ptInfo = new PatientDtoImpl(ptId, forName, lastName);
       //kalder save som connecter til databasen og indsætter data i databasen
        ptDao.save(ptDto);

        //Fjerner det indtastede data
        text1.clear();
        text2.clear();
        text3.clear();
        text4.clear();
    }
}

