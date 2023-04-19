module org.alda.dsm.utl.examenbdsql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.alda.dsm.utl.examenbdsql to javafx.fxml;
    exports org.alda.dsm.utl.examenbdsql;
}