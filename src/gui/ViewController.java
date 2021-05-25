package gui;

import Excecoes.OperacaoNIndentificada;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
	private TextField txtoperacao;
	@FXML
	private TextField txtNumero1;
	@FXML
	private TextField txtNumber2;
	@FXML
	private Label labelResult;
	@FXML
	private Button btsun;

	public void onbtsuntAction() throws OperacaoNIndentificada {
		try {

			double numero1 = Double.parseDouble(txtNumero1.getText());

			double numero2 = Double.parseDouble(txtNumber2.getText());
			
			String operacao = txtoperacao.getText();
			
			double resultado = 0.0;

			if (operacao.equals("1")) {
				resultado = numero1 - numero2;
			} else if (operacao.equals("2")) {
				resultado = numero1 + numero2;
			} else if (operacao.equals("3")) {
				resultado = numero1 * numero2;
			} else if (operacao.equals("4")) {
				resultado = numero1 / numero2;
			} else if (!operacao.contains("1") || !operacao.contains("2") || !operacao.contains("3") || !operacao.contains("4")) {
				Alerts.showAlert("Erro", null, "Operação não identificada!", AlertType.ERROR);
			} else {
				throw new OperacaoNIndentificada("Operação não identificada!");
			}
			
			
			labelResult.setText(String.valueOf(resultado));
			
		} catch (NumberFormatException  e) {
			Alerts.showAlert("Não se deve inserir letras!", null, e.getMessage(), AlertType.ERROR);
		//} catch (OperacaoNIndentificada e) {
			//Alerts.showAlert(e.toString(), null, e.getMessage(), AlertType.ERROR);
		}
		
	}

}
