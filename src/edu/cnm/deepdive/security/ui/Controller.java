/**
 * 
 */
package edu.cnm.deepdive.security.ui;

import edu.cnm.deepdive.security.core.PassphraseGenerator;
import edu.cnm.deepdive.security.core.SecurePasswordGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * @author David S. Martinez
 *
 */
public class Controller {
	private SecurePasswordGenerator passwordGenerator = new SecurePasswordGenerator();
	private PassphraseGenerator passphraseGenerator = new PassphraseGenerator();
	@FXML
	 private CheckBox upperIncluded;
	@FXML
	 private CheckBox lowerIncluded;
	@FXML
	 private CheckBox punctuationIncluded;
	@FXML
	private CheckBox numbersIncluded;
	@FXML
	 private CheckBox ambiguousExcluded;
	@FXML 
	private Slider passwordLength;
	@FXML
	private TextField password;
	@FXML
	private Label passwordLengthLabel;
	@FXML
	private Button generatePassword;
	

	@FXML
	private ChoiceBox<String> delimiter;
	@FXML
	private Slider passphraseLength;
	@FXML
	private Label passphraseLengthLabel;
	@FXML
	private Label delimiterLabel;
	@FXML
	private TextField passphrase;
	@FXML
	private Button generatePassphrase;
	
	@FXML 
	private void initialize() {
		upperIncluded.setSelected(passwordGenerator.isUpperCaseIncluded());
		lowerIncluded.setSelected(passwordGenerator.isUpperCaseIncluded());
		punctuationIncluded.setSelected(passwordGenerator.isUpperCaseIncluded());
		ambiguousExcluded.setSelected(passwordGenerator.isUpperCaseIncluded());
		numbersIncluded.setSelected(passwordGenerator.isNumbersIncluded());
		passwordLengthLabel.setLabelFor(passwordLength);
		passwordLength.setValue(passwordGenerator.getMinLength());
		checkPasswordOptions();
		 delimiterLabel.setLabelFor(delimiter);
//		 ChoiceBox cb = new ChoiceBox();
//		 cb.getItems().addAll("!", "?", "(Space)", "&amp", "#", "*", "%", "@");
		 passphraseLengthLabel.setLabelFor(passphraseLength);
		 passphraseLength.setValue(passphraseGenerator.getLength());
	}

	@FXML
	private void checkPasswordOptions() {
		generatePassword.setDisable(!upperIncluded.isSelected()
		&& !lowerIncluded.isSelected()
		&& !numbersIncluded.isSelected()
		&& !punctuationIncluded.isSelected());
	}
	
	  @FXML
	  private void generatePassword() {
	    int length = (int) Math.round(passwordLength.getValue());
	    passwordGenerator.setUpperCaseIncluded(upperIncluded.isSelected());
	    passwordGenerator.setLowerCaseIncluded(lowerIncluded.isSelected());
	    passwordGenerator.setNumbersIncluded(numbersIncluded.isSelected());
	    passwordGenerator.setPunctuationIncluded(punctuationIncluded.isSelected());
	    passwordGenerator.setAmbiguousExcluded(ambiguousExcluded.isSelected());
	    if (length > passwordGenerator.getMaxLength()) {
	      passwordGenerator.setMaxLength((int) Math.round(passwordLength.getValue()));
	      passwordGenerator.setMinLength((int) Math.round(passwordLength.getValue()));
	    } else {
	      passwordGenerator.setMinLength((int) Math.round(passwordLength.getValue()));
	      passwordGenerator.setMaxLength((int) Math.round(passwordLength.getValue()));
	    }
	    password.setText(passwordGenerator.generate());
	  }
	  @FXML
	  private void generatePassphrase() {
		  int length = (int) Math.round(passphraseLength.getValue());
		  String d = delimiter.getValue();
		  passphraseGenerator.setLength(length);
		  passphraseGenerator.setDelimiter(d);
		  passphrase.setText(passphraseGenerator.generate());
	  }
}
	 
