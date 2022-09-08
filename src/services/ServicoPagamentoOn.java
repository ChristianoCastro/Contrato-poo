package services;

public interface ServicoPagamentoOn {
	double taxaDePagamento(double quantia);
	double juros(double quantia, int meses);
}