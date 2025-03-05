module com.enviro.assessment.grad001.mashabarapholo.banking_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;

    opens com.enviro.assessment.grad001.mashabarapholo.banking_system to javafx.fxml;
    exports com.enviro.assessment.grad001.mashabarapholo.banking_system;
}