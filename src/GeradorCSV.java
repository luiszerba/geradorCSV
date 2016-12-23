
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

public class GeradorCSV {

	public static void main(String[] args) {

		GeradorCSV geradorCSV = new GeradorCSV();
		List<String> firstName = geradorCSV.readAllLines("CSV_Database_of_First_Names.csv");
		List<String> lastName = geradorCSV.readAllLines("CSV_Database_of_Last_Names.csv");
		List<String> products = geradorCSV.readAllLines("CSV_Database_of_Products.csv");

//		System.out.println(products.size());
//		System.out.println(geradorCSV.generateRandomDate());
		
		List<CustomerInformation> loginSocio = 
				geradorCSV.generateLogins(firstName, lastName, products, 200);
//		for (CustomerInformation nome : loginSocio) {
//			System.out.println(nome);
//		}
//		System.out.println(loginSocio.size());
		
		try{
			String csvFile = "/Users/lcorrea/Documents/workspaceEE/GeradorCSV/dataExportProductsSAMS.csv";
	        FileWriter writer = new FileWriter(csvFile);
	
	        //CSVUtils.writeLine(writer, Arrays.asList("Cliente","Email","ID Cartão Sócio","Localizador","clubeFavorito","Data da Compra","produto"));
	        CSVUtils.writeLine(writer, Arrays.asList("Cliente","Perfil","Tipo", "Email","ID Cartão Sócio","Localizador","clubeFavorito","Ultima Compra","Gênero","Faixa Etária","Familia","Ticket Médio"));
	        
	        for(CustomerInformation login:loginSocio){
	        	System.out.println(login);
	        	//for(String produtos:login.produtos){
	        		CSVUtils.writeLine(writer, Arrays.asList(
	        				login.getFirstName() + " " + login.getLastName(),
	        				login.getPerfil(),
	        				login.getTipoCliente(),
	        				login.getEmail(),
	        				login.getNumeroCartaoSocio(),
	        				login.getLocalizadorClube(),
	        				login.getClubeFavorito(),
	        				login.getUltimaCompra(),
	        				login.getGenero(),
	        				login.getFaixaEtaria(),
	        				login.getFamiliaCompra(),
	        				""+login.getTicketMedio()));
//	        				produtos
//	        				));
	        	//}
	        }
//	        CSVUtils.writeLine(writer, Arrays.asList("a", "b", "c", "d"));
	
	//        //custom separator + quote
	//        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');
	//
	//        //custom separator + quote
	//        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');
	//
	//        //double-quotes
	//        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc\"c"));
	
	
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

	private final static String[] localizacoes = new String[] { "Águas Claras", "Bom Retiro", "Brasília", "Campinas",
			"Contagem", "Curitiba - Atuba", "Curitiba - Barigui", "Fortaleza", "Goiânia", "Guarulhos", "Linha Amarela",
			"Maceió", "Natal", "Niterói", "Osasco", "Porto Alegre", "Radial Leste", "Recife", "Ribeirão Preto",
			"Salvador", "Santo Amaro", "Santo André", "São Bernardo do Campo", "São Caetano do Sul",
			"São José dos Campos", "Tamboré", "Vitória" };

	private final static String [] tipo = new String [] {"PJ","PF"};
	private final static String [] mes = new String [] {"jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov","dez"};
	private final static String [] familia = new String []{"Descartáveis","Limpeza","Conservas","Higiene","Molhos e Temperos","Papelaria","Infantil","Matinais"};
	private final static String [] faixaEtaria = new String []{
			"Abaixo de 30 anos",
			"de 30 até 40 anos",
			"de 40 até 50 anos",
			"acima de 50 anos"
	};
	
	private final static String [] genero = new String [] {"M","F"};
	
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
	
	private List<CustomerInformation> generateLogins(
			List<String> firstName, List<String> lastName, List<String> products,
			int totalOfRecords) {
		List<CustomerInformation> retorno = new ArrayList<CustomerInformation>();

		Random rFirstName = new Random(System.currentTimeMillis());
		Random rLastName = new Random(System.currentTimeMillis());
		Random rEmails = new Random(System.currentTimeMillis());
		Random rLocalizacoes = new Random(System.currentTimeMillis());
		Random rHistoricoCompras = new Random(System.currentTimeMillis());
		Random rCartaoSocio = new Random(System.currentTimeMillis());
		Random rTipoCliente = new Random(System.currentTimeMillis());
		Random rMesCompra = new Random(System.currentTimeMillis());
		Random rFamiliaCompra = new Random(System.currentTimeMillis());
		Random rTicketMedio = new Random(System.currentTimeMillis());
		Random rFaixaEtaria = new Random(System.currentTimeMillis());
		Random rGenero = new Random(System.currentTimeMillis());

		for (int i = 0; i < totalOfRecords; i++) {
			CustomerInformation item = new CustomerInformation();
			item.setFirstName(firstName.get(rFirstName.nextInt(firstName.size())));
			item.setLastName(lastName.get(rLastName.nextInt(lastName.size())));
			item.setEmailProvider(emails[rEmails.nextInt(emails.length)]);
			item.setClubeFavorito(localizacoes[rLocalizacoes.nextInt(localizacoes.length)]);
			item.setNumeroCartaoSocio("SAMS-"+rCartaoSocio.nextInt(65535));
			item.setLocalizadorClube("LOC-SAMS"+rCartaoSocio.nextInt(65535));
			item.setDataCompra(generateRandomDate());
			item.setTipoCliente(tipo[rTipoCliente.nextInt(tipo.length)]);
			item.setUltimaCompra(mes[rMesCompra.nextInt(mes.length)]);
			item.setFamiliaCompra(familia[rFamiliaCompra.nextInt(familia.length)]);
			item.setTicketMedio(400+rTicketMedio.nextInt(400));
			item.setFaixaEtaria(faixaEtaria[rFaixaEtaria.nextInt(faixaEtaria.length)]);
			item.setGenero(genero[rGenero.nextInt(genero.length)]);
			item.setPerfil(profile[rGenero.nextInt(profile.length)]);
			
//			for(int j=0; j < rHistoricoCompras.nextInt(10); j++){
//				item.getProdutos().add(products.get(rHistoricoCompras.nextInt(products.size())));
//			}
			
			retorno.add(item);
		}
		return retorno;
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
