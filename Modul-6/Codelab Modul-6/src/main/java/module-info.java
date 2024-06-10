module com.main.codelab {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    // Tambahkan modul lain yang mungkin Anda butuhkan
    opens com.main.codelab to javafx.fxml;
    exports com.main.codelab;
}
