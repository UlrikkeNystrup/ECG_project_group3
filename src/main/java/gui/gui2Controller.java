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
    private String doctorId;

    public TextField text1;
    public TextField text2;
    public TextField text3;
    public TextField text4;

    public void savePtData(MouseEvent mouseEvent) {
        /* String ptId;
         String forName;
         String lastNAme;*/

        ptId = text1.getText();
        forName = text2.getText();
        lastName = text3.getText();
        doctorId = text4.getText();

        ptDto.setPatientId(ptId);
        //System.out.println(ptId);
        //System.out.println(ptDto.getPatientId());

        ptDto.setFirstName(forName);
        ptDto.setLastName(lastName);
        ptDto.setDoctorId(doctorId);

        //PatientDtoImpl ptInfo = new PatientDtoImpl(ptId, forName, lastName);
        ptDao.save(ptDto);
    }
}

