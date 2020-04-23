package br.com.munif.treinamento.oo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Programa2 {

	public static void main(String[] args) {
		System.out.println("Inicio de Streams");
		List<Nome> nomes = nomesFrequentes();
/*		System.out.println("Primeiro " + primeiro(nomes));
		System.out.println("Total da amostra " + somaFrequencias(nomes));
		System.out.println("Total da amostra " + somaFrequenciasForEach(nomes));
		mostreOsMaisDe2M(nomes);
		System.out.println("Mais de 2M " + filtraMaisDe2M(nomes));
		System.out.println("Mais Frequente " + maisFrequente(nomes));
		System.out.println("Menos Frequente " + menosFrequente(nomes));
		System.out.println("Com 5 letras " + filtraComXLetras(nomes, 5));
		System.out.println("Com 6 letras " + filtraComXLetras(nomes, 6));
		System.out.println("Mais Frequente " + maisFrequente(filtraComXLetras(nomes, 6)));
		System.out.println("Menos Frequente " + menosFrequente(filtraComXLetras(nomes, 6)));
		System.out.println("Média de frequencia " + somaFrequencias(nomes) / nomes.size());
		System.out.println("Média de frequencia " + (1.0 * somaFrequencias(nomes) / nomes.size()));
		System.out.println("Média de frequencia " + Math.round(1.0 * somaFrequencias(nomes) / nomes.size()));
*/
		System.out.println("Tem mais 100.000 e menos de 200.000 " + noItervalo(nomes, 100000, 200000).size());
		System.out.println("Tem mais 0 e menos de 99.999 " + noItervalo(nomes, 0, 99999).size());
		System.out.println("2Tem mais 100.000 e menos de 200.000 " + noItervaloStream(nomes, 100000, 200000).size());
		System.out.println("2Tem mais 0 e menos de 99.999 " + noItervaloStream(nomes, 0, 99999).size());
		System.out.println("Frequencia Impar " + frequenciaImpar(nomes).size());
		System.out.println("Frequencia Par " + frequenciaPar(nomes).size());
		System.out.println("2Frequencia Impar " + frequenciaImparStream(nomes).size());
		System.out.println("2Frequencia Par " + frequenciaParStream(nomes).size());

		System.out.println("Total " + nomes.size());
		System.out.println("Contem Maria " + subString(nomes, "ana"));


	}




	private static List<Nome> noItervalo(List<Nome> nomes, int min, int max) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome nome : nomes) {
			// && || !      Operadores lógicos
			// Não são & | ^           1100 | 0011 = 1111 
			if (nome.getFrequencia() >= min && nome.getFrequencia() <= max) {
				toReturn.add(nome);
			}
		}
		return toReturn;
	}
	
	private static List<Nome> noItervaloStream(List<Nome> nomes, int min, int max) {
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()>= min && nome.getFrequencia() <= max)
		        .collect(Collectors.toList());
		return toReturn;
	}
	
	
	private static List<Nome> frequenciaImpar(List<Nome> nomes) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome nome : nomes) {
			if (nome.getFrequencia() % 2 == 1 ) {
				toReturn.add(nome);
			}
		}
		return toReturn;
	}
	private static List<Nome> frequenciaImparStream(List<Nome> nomes) {
		// TODO Auto-generated method stub
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()% 2 == 1)
		        .collect(Collectors.toList());
		return toReturn;
	}	
	private static List<Nome> subString(List<Nome> nomes,String subString) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome nome : nomes) {
			if (nome.getNome().toLowerCase().contains(subString.toLowerCase()) ) {
				toReturn.add(nome);
			}
		}
		return toReturn;
	}
	private static List<Nome> frequenciaParStream(List<Nome> nomes) {
		// TODO Auto-generated method stub
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()% 2 == 0)
		        .collect(Collectors.toList());
		return toReturn;
	}
	
	private static List<Nome> frequenciaPar(List<Nome> nomes) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome nome : nomes) {
			if (nome.getFrequencia() % 2 == 0 ) {
				toReturn.add(nome);
			}
		}
		return toReturn;
	}

	public static Nome primeiro(List<Nome> nomes) {
		return nomes.get(0);
	}

	public static int somaFrequencias(List<Nome> nomes) {
		int soma = 0;
		for (int i = 0; i < nomes.size(); i++) {
			Nome nome = nomes.get(i);
			soma = soma + nome.getFrequencia();
		}
		return soma;
	}

	public static int somaFrequenciasForEach(List<Nome> nomes) {
		int soma = 0;
		for (Nome nome : nomes) {
			soma = soma + nome.getFrequencia();
		}
		return soma;
	}

	public static void mostreOsMaisDe2M(List<Nome> nomes) {
		for (Nome nome : nomes) {
			if (nome.getFrequencia() >= 2000000) {
				System.out.println(nome);
			}
		}
	}

	public static List<Nome> filtraMaisDe2M(List<Nome> nomes) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome nome : nomes) {
			if (nome.getFrequencia() >= 2000000) {
				toReturn.add(nome);
			}
		}
		return toReturn;
	}

	public static List<Nome> filtraComXLetras(List<Nome> nomes, int tamanho) {
		List<Nome> toReturn = new ArrayList<Nome>();
		for (Nome candidato : nomes) {
			if (candidato.getNome().length() == tamanho) {
				toReturn.add(candidato);
			}
		}
		return toReturn;
	}

	public static Nome maisFrequente(List<Nome> nomes) {
		if (nomes.size() == 0) {
			throw new RuntimeException("Lista vazia");
		}
		Nome maisFrequente = nomes.get(0);
		for (Nome nome : nomes) {
			if (nome.getFrequencia() > maisFrequente.getFrequencia()) {
				maisFrequente = nome;
			}
		}
		return maisFrequente;
	}

	public static Nome menosFrequente(List<Nome> nomes) {
		if (nomes.size() == 0) {
			throw new RuntimeException("Lista vazia");
		}
		Nome menosFrequente = nomes.get(0);
		for (Nome nome : nomes) {
			if (nome.getFrequencia() < menosFrequente.getFrequencia()) {
				menosFrequente = nome;
			}
		}
		return menosFrequente;
	}

	public static List<Nome> nomesFrequentes() {
		Nome nomes[] = { new Nome("GUILHERME", 529001), new Nome("ALINE", 511737), new Nome("LEANDRO", 509248),
				new Nome("TIAGO", 495211), new Nome("SANDRA", 480379), new Nome("ANDERSON", 473250),
				new Nome("CAMILA", 471559), new Nome("RICARDO", 469703), new Nome("MARCIO", 468046),
				new Nome("AMANDA", 466432), new Nome("JORGE", 465949), new Nome("BRUNA", 463548),
				new Nome("SEBASTIAO", 462505), new Nome("JESSICA", 458284), new Nome("ALEXANDRE", 444097),
				new Nome("ROBERTO", 437288), new Nome("LETICIA", 435628), new Nome("JULIA", 431842),
				new Nome("JOAO", 2984119), new Nome("ANTONIO", 2576348), new Nome("FRANCISCO", 1772197),
				new Nome("CARLOS", 1489191), new Nome("PAULO", 1423262), new Nome("PEDRO", 1219605),
				new Nome("LUCAS", 1127310), new Nome("LUIZ", 1107792), new Nome("MARCOS", 1106165),
				new Nome("LUIS", 935905), new Nome("EDSON", 431543), new Nome("LUCIANA", 431401),
				new Nome("DIEGO", 424428), new Nome("VITOR", 422903), new Nome("VANESSA", 418838),
				new Nome("SERGIO", 404991), new Nome("MARIANA", 383387), new Nome("GABRIELA", 381650),
				new Nome("VERA", 376958), new Nome("VITORIA", 369004), new Nome("LARISSA", 361845),
				new Nome("CLAUDIA", 359494), new Nome("BEATRIZ", 356351), new Nome("LUANA", 356300),
				new Nome("RITA", 355552), new Nome("SONIA", 355219), new Nome("MARIA", 11734129),
				new Nome("JOSE", 5754529), new Nome("ANA", 3089858), new Nome("GABRIEL", 932449),
				new Nome("RAFAEL", 821638), new Nome("FRANCISCA", 725642), new Nome("DANIEL", 711338),
				new Nome("MARCELO", 693215), new Nome("BRUNO", 668217), new Nome("EDUARDO", 632664),
				new Nome("FELIPE", 621460), new Nome("RAIMUNDO", 613361), new Nome("RODRIGO", 601650),
				new Nome("ANTONIA", 592815), new Nome("MANOEL", 592345), new Nome("MATEUS", 588819),
				new Nome("ANDRE", 583808), new Nome("ADRIANA", 567968), new Nome("JULIANA", 564706),
				new Nome("FERNANDO", 556346), new Nome("MARCIA", 553706), new Nome("FABIO", 547965),
				new Nome("LEONARDO", 547601), new Nome("GUSTAVO", 541480), new Nome("FERNANDA", 534757),
				new Nome("PATRICIA", 531065), new Nome("CLAUDIO", 352031), new Nome("MATHEUS", 350434),
				new Nome("RENATA", 347001), new Nome("THIAGO", 343737), new Nome("ELIANE", 343168),
				new Nome("JOSEFA", 342606), new Nome("SIMONE", 340499), new Nome("GERALDO", 340357),
				new Nome("ADRIANO", 338315), new Nome("LUCIANO", 337492), new Nome("JULIO", 336030),
				new Nome("NATALIA", 335326), new Nome("RENATO", 329535), new Nome("CRISTIANE", 328790),
				new Nome("CARLA", 326684), new Nome("DEBORA", 313947), new Nome("ALEX", 311536),
				new Nome("ROSANGELA", 310889), new Nome("JAQUELINE", 309115), new Nome("ROSA", 307184),
				new Nome("VINICIUS", 304822), new Nome("DANIELA", 304310), new Nome("APARECIDA", 304024),
				new Nome("MARLENE", 301890), new Nome("TEREZINHA", 299037), new Nome("RAIMUNDA", 297300),
				new Nome("ROGERIO", 293596), new Nome("SAMUEL", 293243), new Nome("ANDREIA", 292090),
				new Nome("FABIANA", 291910), new Nome("LUCIA", 287917), new Nome("RAQUEL", 286415),
				new Nome("ANGELA", 278796), new Nome("RAFAELA", 275017), new Nome("RONALDO", 270324),
				new Nome("JOANA", 269732), new Nome("MARIO", 269379), new Nome("FLAVIO", 266719),
				new Nome("IGOR", 266642), new Nome("DOUGLAS", 266507), new Nome("LUZIA", 258948),
				new Nome("ELAINE", 257073), new Nome("DAVI", 255976), new Nome("JEFERSON", 253819),
				new Nome("MANUEL", 253784), new Nome("DANIELE", 253521), new Nome("REGINA", 253086),
				new Nome("CICERO", 248627), new Nome("DAIANE", 244829), new Nome("SUELI", 244584),
				new Nome("ALESSANDRA", 243633), new Nome("VICTOR", 242154), new Nome("MIGUEL", 240880),
				new Nome("ISABEL", 239654), new Nome("ROBSON", 236282), new Nome("MAURICIO", 235778),
				new Nome("SARA", 234286), new Nome("FLAVIA", 233904), new Nome("BIANCA", 233715),
				new Nome("DANILO", 233329), new Nome("ERICA", 232056), new Nome("VIVIANE", 230822),
				new Nome("HENRIQUE", 228718), new Nome("CAIO", 227778), new Nome("REGINALDO", 225817),
				new Nome("SILVANA", 223894), new Nome("PRISCILA", 223128), new Nome("PAULA", 222577),
				new Nome("LUIZA", 220521), new Nome("TEREZA", 219822), new Nome("ISABELA", 216884),
				new Nome("MARTA", 214961), new Nome("JOAQUIM", 214504), new Nome("BENEDITO", 214024),
				new Nome("CAROLINE", 213648), new Nome("GILBERTO", 213266), new Nome("JANAINA", 210831),
				new Nome("LAURA", 210549), new Nome("MARLI", 210457), new Nome("TATIANE", 209635),
				new Nome("MARINA", 208542), new Nome("MARCO", 208076), new Nome("ALAN", 207442),
				new Nome("SILVIA", 204496), new Nome("MONICA", 203930), new Nome("TAIS", 202516),
				new Nome("MICHELE", 202003), new Nome("NELSON", 200581), new Nome("SOLANGE", 200064),
				new Nome("EDNA", 199612), new Nome("FATIMA", 198083), new Nome("HELENA", 197591),
				new Nome("CRISTIANO", 195807), new Nome("CRISTINA", 192698), new Nome("ALICE", 192260),
				new Nome("CAROLINA", 191221), new Nome("ROSANA", 190764), new Nome("ELIAS", 190702),
				new Nome("WILSON", 188800), new Nome("VALDIR", 188122), new Nome("ANDRESSA", 185738),
				new Nome("CELIA", 184516), new Nome("VALERIA", 184492), new Nome("ELIANA", 181921),
				new Nome("MUNIF", 1), new Nome("SABRINA", 179643), new Nome("EMERSON", 177935),
				new Nome("LUAN", 177045), new Nome("ANDREA", 176094), new Nome("DAVID", 174957),
				new Nome("TANIA", 172608), new Nome("RENAN", 171593), new Nome("BARBARA", 171342),
				new Nome("SEVERINO", 170695), new Nome("THAIS", 169620), new Nome("DENISE", 169315),
				new Nome("ROSELI", 169171), new Nome("FABRICIO", 167879), new Nome("MAURO", 166776),
				new Nome("GISELE", 165343), new Nome("JONAS", 165105), new Nome("MARILENE", 164393),
				new Nome("KATIA", 163681), new Nome("EVA", 161039), new Nome("GILMAR", 160511),
				new Nome("JEAN", 160076), new Nome("FABIANO", 159150) };
		return Arrays.asList(nomes);
	}

}
//		nomes.forEach(n->System.out.println(n));

// https://stackify.com/streams-guide-java-8/
// https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
// https://www.baeldung.com/java-8-streams
