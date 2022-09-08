package app;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Prestacao;
import services.ContratoDeServico;
import services.ServicoPaypal;

public class Programa {

	public static void main(String[] args)throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insira os dados do contrato");
		System.out.print("Numero: ");
		int numero= sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Insira o número de prestações: ");
		int n = sc.nextInt();
		
		ContratoDeServico contratoDeServico = new ContratoDeServico(new ServicoPaypal());
		
		contratoDeServico.processoContrato(contrato, n);
		
		System.out.println("Prestações: ");
		for (Prestacao x : contrato.getPrestacoes()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}