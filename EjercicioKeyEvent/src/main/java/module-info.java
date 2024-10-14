module es.ieslosmontecillos.ejerciciokeyevent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens es.ieslosmontecillos.ejerciciokeyevent to javafx.fxml;
    exports es.ieslosmontecillos.ejerciciokeyevent;
}