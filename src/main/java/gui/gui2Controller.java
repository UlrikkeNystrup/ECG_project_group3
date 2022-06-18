package gui;
import data.dao.PatientDaoImpl;
import data.dto.PatientDtoImpl;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
public class gui2Controller {
    PatientDtoImpl ptDto =new PatientDtoImpl();

    PatientDaoImpl ptDao = new PatientDaoImpl();

    private String ptId;
    private String forName;
    private String lastName;

    public TextField text1;
    public TextField text2;
    public TextField text3;

    public void savePtData(MouseEvent mouseEvent) {
        /* String ptId;
         String forName;
         String lastNAme;*/


        ptId = text1.getText();
        forName = text2.getText();
        lastName = text3.getText();

        ptDto.setPatientId(ptId);
        ptDto.setFirstName(forName);
        ptDto.setLastName(lastName);

        //PatientDtoImpl ptInfo = new PatientDtoImpl(ptId, forName, lastName);
        ptDao.save();
    }
}

