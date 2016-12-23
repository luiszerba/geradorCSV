import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInformation {
	
	private String firstName;
	private String lastName;
	private String emailProvider;
	private String numeroCartaoSocio;
	private String localizadorClube;
	private String clubeFavorito;
	private String dataCompra;
	private String tipoCliente;
	private String ultimaCompra;
	private String familiaCompra;
	private int ticketMedio;
	private String faixaEtaria;
	private String genero;
	private String perfil;
	
	List<String> produtos = new ArrayList<String>();
	
	public String getFirstName() {
		return firstName;
	}


	

	public int getTicketMedio() {
		return ticketMedio;
	}




	public void setTicketMedio(int ticketMedio) {
		this.ticketMedio = ticketMedio;
	}




	public String getFaixaEtaria() {
		return faixaEtaria;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}




	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}




	public String getUltimaCompra() {
		return ultimaCompra;
	}




	public void setUltimaCompra(String ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}




	public String getDataCompra() {
		return dataCompra;
	}



	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}



	public String getNumeroCartaoSocio() {
		return numeroCartaoSocio;
	}

	
	


	public String getFamiliaCompra() {
		return familiaCompra;
	}




	public void setFamiliaCompra(String familiaCompra) {
		this.familiaCompra = familiaCompra;
	}




	public String getTipoCliente() {
		return tipoCliente;
	}



	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}



	public void setNumeroCartaoSocio(String numeroCartaoSocio) {
		this.numeroCartaoSocio = numeroCartaoSocio;
	}



	public String getLocalizadorClube() {
		return localizadorClube;
	}



	public void setLocalizadorClube(String localizadorClube) {
		this.localizadorClube = localizadorClube;
	}



	public String getClubeFavorito() {
		return clubeFavorito;
	}



	public void setClubeFavorito(String clubeFavorito) {
		this.clubeFavorito = clubeFavorito;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail(){
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + emailProvider;
	}


	public String getLastName() {
		return lastName;
	}



	public String getPerfil() {
		return perfil;
	}




	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmailProvider() {
		return emailProvider;
	}



	public void setEmailProvider(String emailProvider) {
		this.emailProvider = emailProvider;
	}

	


	public List<String> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}



	@Override
	public String toString() {
		return "CustomerInformation [firstName=" + firstName + ", lastName=" + lastName + ", emailProvider="
				+ emailProvider + ", numeroCartaoSocio=" + numeroCartaoSocio + ", localizadorClube=" + localizadorClube
				+ ", clubeFavorito=" + clubeFavorito + ", produtos=" + produtos + "]";
	}



	

	
}
