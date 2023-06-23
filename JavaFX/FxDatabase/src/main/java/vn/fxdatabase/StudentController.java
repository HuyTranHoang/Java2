package vn.fxdatabase;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.EnumFilter;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.sql.*;
import java.time.LocalDate;
import java.util.Comparator;

public class StudentController {

    private static Connection connection = DatabaseUtils.getInstance();

    @FXML
    private Label lblError;

    @FXML
    private FontAwesomeIconView iconErrDob;

    @FXML
    private FontAwesomeIconView iconErrGender;

    @FXML
    private FontAwesomeIconView iconErrName;

    @FXML
    private MFXButton btnEdit;

    @FXML
    private MFXButton btnAdd;

    @FXML
    private MFXButton btnDelete;

    @FXML
    private MFXButton btnUpdate;

    @FXML
    private MFXRadioButton rbFemale;

    @FXML
    private MFXRadioButton rbMale;

    @FXML
    private MFXDatePicker dpDob;

    @FXML
    private ToggleGroup tggGender;

    @FXML
    private MFXTextField txtName;

    @FXML
    private MFXTableView<Student> tvStudent;

    private int currentStudentId = -1;

    public void initialize(){
//        Platform.runLater(() -> {
//
//        });

        addColToTableView();
        insertDataToTableView();

//        TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
//            String newText = change.getControlNewText();
//            if (newText.matches("^[a-zA-Z]*$")) {
//                return change;
//            }
//            return null; // Reject the change
//        });
//
//        txtName.setTextFormatter(textFormatter);

        txtName.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String character = event.getCharacter();
                if(!character.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ" +
                        "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu" +
                        "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]"))
                    event.consume();
            }
        });


    }


    private void showAlertWithHeaderText(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("app.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

        alert.showAndWait();
    }

    private void showErrorAlertWithHeaderText(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("app.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");


        alert.showAndWait();
    }

    private void addColToTableView() {
        MFXTableColumn<Student> idColumn = new MFXTableColumn<>("ID", true, Comparator.comparing(Student::getId));
        MFXTableColumn<Student> nameColumn = new MFXTableColumn<>("Name", true, Comparator.comparing(Student::getName));
        MFXTableColumn<Student> genderColumn = new MFXTableColumn<>("Gender", true, Comparator.comparing(Student::getGender));
        MFXTableColumn<Student> dobColumn = new MFXTableColumn<>("Date of birth", true, Comparator.comparing(Student::getDob));

        idColumn.setRowCellFactory(student -> new MFXTableRowCell<>(Student::getId));
        nameColumn.setRowCellFactory(student -> new MFXTableRowCell<>(Student::getName));
        genderColumn.setRowCellFactory(student -> new MFXTableRowCell<>(Student::getGender));
        dobColumn.setRowCellFactory(student -> new MFXTableRowCell<>(Student::getDob));


        tvStudent.getTableColumns().addAll(idColumn, nameColumn, genderColumn, dobColumn);
        tvStudent.getFilters().addAll(
                new StringFilter<>("Name", Student::getName),
                new IntegerFilter<>("ID", Student::getId),
                new EnumFilter<>("Gender", Student::getGender, Gender.class)
        );
    }

    private void insertDataToTableView() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ObservableList<Student> data = FXCollections.observableArrayList();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student ORDER BY id ASC");
            while (resultSet.next()) {
                Object genderBit;
                genderBit = resultSet.getObject("gender");
                boolean gender = genderBit != null && genderBit.equals(true);
                Gender eGender = gender ? Gender.MALE : Gender.FEMALE;
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        eGender,
                        resultSet.getDate("dob").toLocalDate()
                        );
                data.add(student);
            }
            tvStudent.setItems(data);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean validation() {
        if (txtName.getText().isEmpty()){
            lblError.setText("Name is required");
            iconErrName.getStyleClass().remove("hidden");
            return false;
        } else {
            iconErrName.getStyleClass().add("hidden");
        }

        if (tggGender.getSelectedToggle() == null) {
            lblError.setText("Gender is required");
            iconErrGender.getStyleClass().remove("hidden");
            return false;
        } else {
            iconErrGender.getStyleClass().add("hidden");
        }

        if (dpDob.getValue() == null) {
            lblError.setText("Date of birth is required");
            iconErrDob.getStyleClass().remove("hidden");
            return false;
        } else {
            iconErrDob.getStyleClass().add("hidden");
        }

        lblError.setText("");
        return true;
    }

    @FXML
    void add() {
        if (validation()) {
            String name = txtName.getText();
            LocalDate dob = dpDob.getValue();
            RadioButton selectedRadioButton = (RadioButton) tggGender.getSelectedToggle();
            String selectGender = selectedRadioButton.getText();
            String gender = selectGender.equals("Male") ? "1" : "0";

            try {
                String sql = "INSERT INTO student(name, gender, dob) VALUES(?, ?::bit, ?)";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, gender);
                stmt.setDate(3, Date.valueOf(dob));
                stmt.executeUpdate();
                showAlertWithHeaderText("Add new student successfully!!");
                insertDataToTableView();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            clearInput();
        }
    }

    @FXML
    void edit() {
        Student selectedStudent = tvStudent.getSelectionModel().getSelectedValue();
        if (selectedStudent != null) {
            int id = selectedStudent.getId();
            String name = selectedStudent.getName();
            Gender gender = selectedStudent.getGender();
            LocalDate dob = selectedStudent.getDob();

            txtName.setText(name);

            if (gender == Gender.MALE) {
                rbMale.setSelected(true);
            } else {
                rbFemale.setSelected(true);
            }

            dpDob.setValue(dob);
            currentStudentId = id;
        }
    }

    @FXML
    void update() {
        if (currentStudentId != -1 && validation()) {
            String name = txtName.getText();
            LocalDate dob = dpDob.getValue();
            RadioButton selectedRadioButton = (RadioButton) tggGender.getSelectedToggle();
            String selectGender = selectedRadioButton.getText();
            String gender = selectGender.equals("Male") ? "1" : "0";

            try {
                String sql = "UPDATE student SET name = ?, gender = ?::bit, dob = ? WHERE id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, gender);
                stmt.setDate(3, Date.valueOf(dob));
                stmt.setInt(4, currentStudentId);
                stmt.executeUpdate();
                showAlertWithHeaderText("Update student successfully!!");
                insertDataToTableView();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            tvStudent.getSelectionModel().clearSelection();
            clearInput();
        } else {
            showErrorAlertWithHeaderText("No student selected!");
        }
    }

    @FXML
    void delete() {
        Student selectedStudent = tvStudent.getSelectionModel().getSelectedValue();

        if (selectedStudent != null) {
            int id = selectedStudent.getId();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Do you want to proceed with this action?");

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("app.css").toExternalForm());
            dialogPane.getStyleClass().add("myDialog");


            ButtonType buttonYes = new ButtonType("Yes");
            ButtonType buttonNo = new ButtonType("No");
            alert.getButtonTypes().setAll(buttonYes, buttonNo);

            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == buttonYes) {
                    try {
                        String sql = "DELETE FROM student WHERE id = ?";
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                        showAlertWithHeaderText("Delete student successfully!!");
                        insertDataToTableView();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    tvStudent.getSelectionModel().clearSelection();
                    clearInput();
                }
            });
        } else {
            showErrorAlertWithHeaderText("No student selected!");
        }

    }

    private void clearInput() {
        currentStudentId = -1;
        txtName.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        dpDob.setValue(LocalDate.now());
        dpDob.clear();
    }

}
