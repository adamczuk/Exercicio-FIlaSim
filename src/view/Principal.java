package view;

import javax.swing.JOptionPane;

import adamczuk.nathan.Fila;
import controller.FilaController;

public class Principal {
	

	private static Fila filaGeral = new Fila();
	private static Fila filaPrioritaria = new Fila();

	public static void main(String[] args) {
		
		FilaController controleDeFila = new FilaController();
		
		int opcao = 9;
		do {
			try {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("1 - Obter senha PRIORITÁRIA\n\n" + "2 - Obter senha NORMAL\n\n"
								+ "3 - Chamar para atendimento\n\n" + "9 - Finalizar o programa"));

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ENTRADA INVALIDA\n\nTente novamente");
			}

			validaEntrada(opcao, controleDeFila);

		} while (opcao != 9);
	}

	private static void validaEntrada(int opcao, FilaController controle) {

		switch (opcao) {
		case 1:
			controle.adicionaSenha(filaPrioritaria);
			break;
		case 2:
			controle.adicionaSenha(filaGeral);
			break;
		case 3:
			controle.chamarSenha(filaGeral, filaPrioritaria);
			break;
		case 9:
			break;
		default: 
			JOptionPane.showMessageDialog(null, "ENTRADA INVALIDA\n\n");
		}

	}

}
