package sample.MangeMembers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import DataModels.Employee;
import DataModels.Member;
import static sample.Main.members;
import static sample.Main.trainers;
import static sample.Main.classes;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteMember implements Initializable {

    @FXML Button deleteBtn;
    @FXML TextField ID;

    public void deleteMemberBtnFunc(ActionEvent actionEvent) {
        Employee.removeMember(Integer.parseInt(ID.getText()),members, trainers, classes);
    }

    public void backBtnFunc(ActionEvent actionEvent) {
        Main.stage.setScene(Main.sceneEmPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
