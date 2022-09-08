package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Prestacao;


public class ContratoDeServico {

private ServicoPagamentoOn servicoPagamentoOn;
	
	public ContratoDeServico(ServicoPagamentoOn servicoPagamentoOn) {
		this.servicoPagamentoOn = servicoPagamentoOn;
	}
	
	public void processoContrato(Contrato contrato, int meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
        for (int i = 1; i <= meses; i++) {
            Date data = addMonths(contrato.getData(), i);
            double cotaAtualizada = cotaBasica + servicoPagamentoOn.juros(cotaBasica, i);
            double cotaCompleta = cotaAtualizada +servicoPagamentoOn.taxaDePagamento(cotaAtualizada);
            contrato.addPrestacao (new Prestacao(data, cotaCompleta));
        }
	}
	
	private Date addMonths(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}