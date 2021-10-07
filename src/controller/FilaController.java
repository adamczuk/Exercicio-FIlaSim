/*
 * 
 * O m�todo de chamado que deve seguir a seguinte regra:
 * - Fazer 3 chamadas priorit�rias para 1 da fila n�o priorit�ria
 * - Se n�o houver priorit�rios, j� se deve chamar dos n�o priorit�rios
 * - Se n�o houver ningu�m nas 2 filas, deve-se gerar um aviso
 */


package controller;

import javax.swing.JOptionPane;

import adamczuk.nathan.Fila;

public class FilaController {

	private int chamadasPrioritarias;

	public FilaController() {
		chamadasPrioritarias = 0;
	}

	public void adicionaSenha(Fila fila) {
		if (fila.isEmpty()) {
			fila.insert(1);
		} else {
			int ultimaPosicao = fila.size() - 1;
			int proximaSenha = 0;

			try {
				proximaSenha = fila.get(ultimaPosicao);
			} catch (Exception e) {
			}

			proximaSenha++;

			fila.insert(proximaSenha);

		}
	}

	public void chamarSenha(Fila filaGeral, Fila filaPrioritaria) {

		if (filaGeral.isEmpty() && filaPrioritaria.isEmpty()) {
			JOptionPane.showMessageDialog(null, "AS FILAS ESTAO VAZIAS");

		} else {
			
			if ((chamadasPrioritarias < 3 || filaGeral.isEmpty()) && filaPrioritaria.size() > 0) {
				try {
					int senhaChamada = filaPrioritaria.remove();

					JOptionPane.showMessageDialog(null, "SENHA: " + senhaChamada + "\nFILA: PRIORITARIA");
					

					++chamadasPrioritarias;

				} catch (Exception e) {
				}
			}

			else {
				try {
					int senhaChamada = filaGeral.remove();

					JOptionPane.showMessageDialog(null, "SENHA: " + senhaChamada + "\nFILA: GERAL");
					
					chamadasPrioritarias = 0;
					
				} catch (Exception e) {
				}
			}

		}
	}

}
