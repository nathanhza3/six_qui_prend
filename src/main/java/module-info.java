module com.example.six_qui_prend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.six_qui_prend to javafx.fxml;
    exports com.example.six_qui_prend;
}