package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Button saveButton;

    @FXML
    private TextArea textArea;
    
    @FXML
    private Button clearBtn;
    
    @FXML
    private TextField titleField;

    private Model model;
    
    public void initModel(Model model) {
		if (this.model != null)
			throw new IllegalStateException("Model can only be initialized once");
		
    	this.model = model;
    	
    	// Bind Model to View
		textArea.textProperty().bindBidirectional(model.bodyText);
		
		titleField.textProperty().bindBidirectional(model.titleText);
		
		// Event Handler
		saveButton.setOnAction(e -> {
			model.save();
        });
		clearBtn.setOnAction(e -> {
			model.clear();
		});
		
    }   
    
	public void initialize() {
		// Write your initialization code here
	}
}