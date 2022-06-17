package gui;

import javafx.scene.control.TextField;

public class gui2Controller {
    public TextField textField1;
    public TextField textField2;
    public TextField textField3;


    public void savePt(String ptId,String firstName,String lastName ){
        this.textField1 = ptId;
        this.textField2 = firstName;
        this.textField3 = lastName;

    }


}
