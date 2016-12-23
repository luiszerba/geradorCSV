
import java.io.FileWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


//Utilizado no C&A
public class GeradorCSV2 {

	public static void main(String[] args) {

		GeradorCSV2 geradorCSV = new GeradorCSV2();
		List<String> firstName = geradorCSV.readAllLines("CSV_Database_of_First_Names.csv");
		List<String> lastName = geradorCSV.readAllLines("CSV_Database_of_Last_Names.csv");
		List<String> products = geradorCSV.readAllLines("CSV_Database_of_Products.csv");

//		System.out.println(products.size());
//		System.out.println(geradorCSV.generateRandomDate());
		
		List<ClienteCEA> loginSocio = 
				geradorCSV.generateLogins(firstName, lastName, products, 10000);
//		for (CustomerInformation nome : loginSocio) {
//			System.out.println(nome);
//		}
//		System.out.println(loginSocio.size());
		
		try{
			String csvFile = "/Users/lcorrea/Documents/workspaceEE/GeradorCSV/dataExportProductsCEA.csv";
	        FileWriter writer = new FileWriter(csvFile);
	
	        //CSVUtils.writeLine(writer, Arrays.asList("Cliente","Email","ID Cartão Sócio","Localizador","clubeFavorito","Data da Compra","produto"));
	        CSVUtils.writeLine(writer, Arrays.asList("Cliente","Email","Loja","Faixa Etária","Ticket Médio","Categoria Produto","Meio de Comunicação","Tipo","Tier"));
	        
	        for(ClienteCEA login:loginSocio){
	        	System.out.println(login);
	        		CSVUtils.writeLine(writer, Arrays.asList(
	        				login.getFirstName() + " " + login.getLastName(),
	        				login.getEmail(),
	        				login.getLoja(),
	        				login.getFaixaEtaria(),
	        				""+login.getTicketMedio(),
	        				login.getSetor(),
	        				login.getMeioComunicacaoPreferencial(),
	        				login.getTipo(),
	        				login.getTier()));
	        }
	        
	        writer.flush();
	        writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	

	public List<String> readAllLines(String filename) {

		try {
			URI uri = this.getClass().getResource(filename).toURI();
			List<String> lines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

			return lines;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private final static String[] emails = new String[] { "@gmail.com", "@hotmail.com", "@yahoo.com.br", "@uol.com.br",
			"@bol.com.br", "@ig.com.br", "@globomail.com", "@oi.com.br", "@pop.com.br", "@r7.com", "@folha.com.br",
			"@zipmail.com.br" };

	private final static String[] localizacoes = new String[] { "Shopping Tietê Plaza", "Shopping D", "Augusta ",
			"Shopping Aricanduva", "Shopping Itaquera", "Shopping Interlagos", "Shopping SP Market",
			"Shopping Boavista", "Shopping Jardim Sul", "Shopping Campo Limpo", "Shopping Jardim Sul",
			"Shopping Morumbi", "Shopping Eldorado", "Shopping Iguatemi", "Raposo Shopping", "Raposo Villa Lobos",
			"Centro São Paulo", "Bourbon Shopping Pompéia", "Shopping West Plaza", "Santana Parque Shopping" };
	
	private final static String[][] categoriaProduto = new String[][] {
			{ "Acessórios", "Bermudas", "Camisetas", "Calças", "Calçados", "Cuecas e meias", "Casacos e jaquetas",
					"Esporte ace", "Moda praia", "Óculos", "Polos", "Pijamas", "Relógios", "Jeans", "Moletons",
					"Personagens" },
			{ "Acessórios", "Blusas", "Bolsas e mochilas", "Calças", "Calçados", "Camisas", "Casacos e jaquetas",
					"Esporte ace", "Shorts e bermudas", "Saias", "Moda íntima", "Moda praia", "Óculos", "Relógios",
					"Vestidos", "Macacões e jardineiras", "Polos", "Jeans" } };

	private final static String [] tipo = new String [] {"PJ","PF"};
	private final static String [] mes = new String [] {"jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov","dez"};
	private final static String [] familia = new String []{"Descartáveis","Limpeza","Conservas","Higiene","Molhos e Temperos","Papelaria","Infantil","Matinais"};
	private final static String [] faixaEtaria = new String []{
			"Abaixo de 30 anos",
			"de 30 até 40 anos",
			"de 40 até 50 anos",
			"acima de 50 anos"
	};
	
	private final static String [] meioComunicacaoPreferencial = new String[]{"Twitter","Facebook","E-mail","SMS","Telefone"};
	private final static String [] tier = {"Bronze","Prata","Ouro","Diamante"};
	
	
	private final static String [] genero = new String [] {"M","F"};
	private final static String [] setor = {"feminino","masculino"};
	
//	private final static String [] profile = new String[]{
//			"Director of Finance",
//			"CEO","Green Fields Media Customer User",
//			"Central Sales","Administrador do sistema"};
	
	private final static String [] profile = new String[]{
			"00e410000016NwWAAU",
			"00e410000016NwjAAE",
			"00e410000016NxGAAU",
			"00e410000016Nx8AAE"
	};
	
	
	private class ClienteCEA{
		private String firstName;
		private String lastName;
		private String emailProvider;
		private String loja;
		private String faixaEtaria;
		private int ticketMedio;
		private String setor;
		private String meioComunicacaoPreferencial;
		private String tipo;
		private String tier;
		
		public String getEmail(){
			return firstName.toLowerCase() + "." + lastName.toLowerCase() + emailProvider;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
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

		public String getLoja() {
			return loja;
		}

		public void setLoja(String loja) {
			this.loja = loja;
		}

		public String getFaixaEtaria() {
			return faixaEtaria;
		}

		public void setFaixaEtaria(String faixaEtaria) {
			this.faixaEtaria = faixaEtaria;
		}

		public int getTicketMedio() {
			return ticketMedio;
		}

		public void setTicketMedio(int ticketMedio) {
			this.ticketMedio = ticketMedio;
		}

		public String getSetor() {
			return setor;
		}

		public void setSetor(String setor) {
			this.setor = setor;
		}

		public String getMeioComunicacaoPreferencial() {
			return meioComunicacaoPreferencial;
		}

		public void setMeioComunicacaoPreferencial(String meioComunicacaoPreferencial) {
			this.meioComunicacaoPreferencial = meioComunicacaoPreferencial;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getTier() {
			return tier;
		}

		public void setTier(String tier) {
			this.tier = tier;
		}

		@Override
		public String toString() {
			return "ClienteCEA [firstName=" + firstName + ", lastName=" + lastName + ", emailProvider=" + emailProvider
					+ ", loja=" + loja + ", faixaEtaria=" + faixaEtaria + ", ticketMedio=" + ticketMedio + ", setor="
					+ setor + ", meioComunicacaoPreferencial=" + meioComunicacaoPreferencial + ", tipo=" + tipo
					+ ", tier=" + tier + "]";
		}
		
		
	};
	
	
	private List<ClienteCEA> generateLogins(
			List<String> firstName, List<String> lastName, List<String> products,
			int totalOfRecords) {
		List<ClienteCEA> retorno = new ArrayList<ClienteCEA>();

				for (int i = 0; i < totalOfRecords; i++) {
					
					
					ClienteCEA item = new ClienteCEA();
					item.setFirstName((String)generateRandomValue(firstName.toArray()));
					item.setLastName((String)generateRandomValue(lastName.toArray()));
					
					item.setEmailProvider((String)generateRandomValue(emails));
					item.setLoja((String)generateRandomValue(localizacoes));
					item.setFaixaEtaria((String)generateRandomValue(faixaEtaria));
					item.setTicketMedio(randBetween(70, 400));
					item.setSetor(
							(String)generateRandomValue(categoriaProduto[
							       "masculino".equals(generateRandomValue(setor))?0:1]));
					item.setMeioComunicacaoPreferencial((String)generateRandomValue(meioComunicacaoPreferencial));
					item.setTipo((String)generateRandomValue(tipo));
					item.setTier((String)generateRandomValue(tier));
					
			retorno.add(item);
		}
		return retorno;
	}
	
	Random random = new Random(System.currentTimeMillis());
	
	private Object generateRandomValue(Object [] object){
		
		return object[random.nextInt(object.length)];
	}
	
	
	public String generateRandomDate(){
		GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(2014, 2016);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        //System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
        return  gc.get(gc.DAY_OF_MONTH) + "/" + (gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.YEAR);
	}
	
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

}
