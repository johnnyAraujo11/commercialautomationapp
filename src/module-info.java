module commercialautomationapp {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens controllers to javafx.graphics, javafx.fxml;
	exports application;
}
