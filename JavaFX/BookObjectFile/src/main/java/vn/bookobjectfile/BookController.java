package vn.bookobjectfile;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class BookController extends ArrayList<Book> {

    @FXML
    private Button btnReadFile;

    @FXML
    private Button btnSaveToFile;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtTitle;
}