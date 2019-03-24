package br.com.fatec.modelo;

/**
 * Verifica se o cpf está de acordo com as normas brasileiras
 * @author Natalia Gonçalves
 * @version 1.0 (Mar 17 2019)
 *
 */
public class ValidaCPF {
	private String cpf;

	public ValidaCPF(String cpf) {
		this.cpf = cpf;
	}
	
	/*
	 * @return true se o CPF for válido
	 */
	
	public boolean isCPFValido() {
		
		//verifica se o valor possui 11 digitos
		String c = cpf.replaceAll("[^0-9]", "");
		if(c.length() == 11) {
			
			//validação do primeiro dígito
			
			int d1 = (int) c.charAt(9) - '0';
			int soma = 0;
			for(int i=0, k=10; i < 9; i++, k--) {
				soma += k * (c.charAt(i)- '0');
			}  
			if (certificaDigito(soma, d1)) {
				
				//validação do segundo dígito
				
				int d2 = c.charAt(10) - '0';
				soma = 0;
				for(int i=0, k=11; i < 10; i++, k--) {
					soma += k * (c.charAt(i)- '0');
				}
				return certificaDigito(soma, d2);
			}
		}
		return false;
	}
	
	private boolean certificaDigito(int soma, int digito) {
		int resto = soma * 10 % 11;
		if(resto < 10 && digito == resto) return true;
		if(resto == 10 && digito == 0) return true;
		return false;
	}
	
}
