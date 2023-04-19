package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.dto.CustomDTO;

public class PendingKeyMoneyFormController {


    public TableView tblReservation;
    public TableColumn colReservationId;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colPaymentStatus;
    public TableColumn colDate;
    public JFXTextField txtStudentId;
    public JFXComboBox cmbPaymentStatus;
    public JFXButton btnUpdate;
    public JFXTextField txtReservationId;
    public JFXTextField txtDate;
    public JFXTextField txtName;
    public JFXTextField txtType;
    public JFXTextField txtRoomTypeId;

    public void initialize(){
        colReservationId.setCellValueFactory(new PropertyValueFactory<>("res_id"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colPaymentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        loadAllData();
    }

    private void loadAllData() {
        try {
            List<CustomDTO> list = pendingKeyMoneyBO.getAllPendingKeyMoneyReservationsUsingReservationStatus();

            for (CustomDTO dto:list
            ) {
                tblReservation.getItems().add(
                        new CustomDTO(dto.getRes_id(),dto.getStudent_id(),dto.getName(),dto.getRoom_type_id(),dto.getType(),dto.getKey_money(),dto.getStatus(),dto.getDate())
                );
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }
}
