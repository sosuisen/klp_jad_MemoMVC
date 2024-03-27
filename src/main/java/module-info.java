// 'mvcapp': Your module name
// 'com.example': Your package name
module mvcapp {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example to javafx.graphics, javafx.fxml;
}
