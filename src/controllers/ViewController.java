package controllers;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Cliente;

public class ViewController implements Initializable{

	@FXML
	private Button sendBtn;
	@FXML
	private Button apagarBtn;
	@FXML
	private Text valorDoNome;
	@FXML
	private Text valorDoEmail;
	@FXML
	private Text valorSenha;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField email;
	
	@FXML
	private PasswordField senha;
	
	// Tabela
	@FXML
	private TableView <Cliente> tabelaClientes;
	
	// Colunas
	@FXML
	private TableColumn <Cliente, String> tabelaNome;
	
	@FXML
	private TableColumn <Cliente, String> tabelaEmail;
	
	@FXML
	private TableColumn <Cliente, String> tabelaSenha;
	
	private ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tabelaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		
	}
	
	@FXML
	private void botaoSalvar() {
		System.out.println("O nome digitado: " + nome.getText());
		
		valorDoNome.setText(nome.getText());
		valorDoEmail.setText(email.getText());
		valorSenha.setText(senha.getText());
		
		Cliente c = new Cliente();
		System.out.println(listaCliente);
		
		c.setNome(nome.getText());
		c.setEmail(email.getText());
		c.setSenha(senha.getText());	
			
		listaCliente.add(c);
		System.out.println(listaCliente);

		
		tabelaClientes.setItems(listaCliente);
		tabelaClientes.refresh();
		
		nome.setText("");
		email.setText("");
		senha.setText("");

	}
	@FXML
	public void onBtnApagar() {

		try {
			Cliente selectedCliente = tabelaClientes.getSelectionModel().getSelectedItem();

			listaCliente.remove(selectedCliente);

			tabelaClientes.setItems(listaCliente);
			tabelaClientes.refresh();

		} catch (Exception e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setContentText("Acredito que não tenha dados na tabela...");
			alert.show();
		}

	}

	}
