package entities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	
		private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		private Date dataDeVencimento;
		private Double quantia;
		
		
		public Prestacao(Date dataDeVencimento, Double quantia) {
				this.dataDeVencimento = dataDeVencimento;
				this.quantia = quantia;
		}
		public Date getDataDeVencimento() {
			return dataDeVencimento;
		}

		public void setDataDeVencimento(Date dataDeVencimento) {
			this.dataDeVencimento = dataDeVencimento;
		}

		public Double getQuantia() {
			return quantia;
		}

		public void setQuantia(Double quantia) {
			this.quantia = quantia;
		}

		@Override
		public String toString() {
			return sdf.format(dataDeVencimento) + " - " + String.format("%.2f", quantia);
	 	}
}