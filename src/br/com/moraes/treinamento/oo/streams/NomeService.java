package br.com.moraes.treinamento.oo.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import br.com.munif.treinamento.oo.streams.Nome;

public class NomeService {
	 List<Nome> noItervaloStream(List<Nome> nomes, int min, int max) {
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()>= min && nome.getFrequencia() <= max)
		        .collect(Collectors.toList());
		return toReturn;
	}
	
	  List<Nome> subStringStream(List<Nome> nomes,String subString) {
		 Map<String, String> result1 = nomes.stream().collect(
             Collectors.toMap(Nome::getNome, Nome::getNome));
		 
		 //como map
		 Map<String, String> resultFilted = result1.entrySet().stream()
				 .filter(x -> x.getKey().contains(subString.toUpperCase()))
				 
				 .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		 //como list
		 List resultFilted2 = result1.entrySet().stream()
				 .filter(x -> x.getKey().contains(subString.toUpperCase()))
				 
				 .collect(Collectors.toList());
		 //usando lista parametro
		 List<Nome> toReturn = nomes.stream()
			        .filter(nome -> nome.getNome().contains(subString.toUpperCase()))
			        .collect(Collectors.toList());
		 	
		 return toReturn;       
		}
	
	 List<Nome> frequenciaImparStream(List<Nome> nomes) {
		// TODO Auto-generated method stub
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()% 2 == 1)
		        .collect(Collectors.toList());
		return toReturn;
	}	
	
	 List<Nome> frequenciaParStream(List<Nome> nomes) {
		// TODO Auto-generated method stub
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()% 2 == 0)
		        .collect(Collectors.toList());
		return toReturn;
	}
	
	 Nome primeiro(List<Nome> nomes) {
		return nomes.get(0);
	}

	  int somaFrequenciasStream(List<Nome> nomes) {
		Integer soma = nomes.stream()
				  .map(nome -> nome.getFrequencia())
				  .reduce(0, Integer::sum);
		return soma;
	}
	
	 IntSummaryStatistics estatistica(List<Nome> nomes) {
		IntSummaryStatistics result = nomes.stream()
                .mapToInt((nome) -> nome.getFrequencia())
                .summaryStatistics();
		return result;
	}
	  Double mediaFrequenciasStream(List<Nome> nomes) {		
		// AVERAGE -- Solution 1
		IntSummaryStatistics stats = nomes.stream()
                .mapToInt((nome) -> nome.getFrequencia())
                .summaryStatistics();
		System.out.println(stats);
		
		// AVERAGE -- Solution 2
		OptionalDouble media = nomes.stream()
	    .mapToInt(nome -> nome.getFrequencia()) //
	    .average(); //
	    //.ifPresent(avg -> System.out.println("Average found is " + avg));

		// AVERAGE -- Solution 3
		double media2 = nomes.stream()
			    .mapToInt(nome -> nome.getFrequencia()) //
			    .average()
			    .getAsDouble();//
			    //.ifPresent(avg -> System.out.println("Average found is " + avg));

		return media2;
	}
	
	public  void mostreOsMaisDe2MStream(List<Nome> nomes,int frequencia) {
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()>= frequencia)
		        .collect(Collectors.toList());
		System.out.println(toReturn);
		//return toReturn;
	}
	
	public  List<Nome> filtraMaisDe2MStream(List<Nome> nomes, int frequencia) {
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getFrequencia()>= frequencia)
		        .collect(Collectors.toList());
		return toReturn;
	}
	
	public  List<Nome> filtraComXLetrasStream(List<Nome> nomes, int tamanho) {
		List<Nome> toReturn = nomes.stream()
		        .filter(nome -> nome.getNome().length()==tamanho)
		        .collect(Collectors.toList());
		return toReturn;
	}

	public  Nome maisFrequenteStream(List<Nome> nomes) {
		if (nomes.size() == 0) {
			throw new RuntimeException("Lista vazia");
		}
		Nome maisFrequente = nomes.get(0);
		
		Comparator<Nome> comparator = Comparator.comparing( Nome::getFrequencia );
		
		// Get Min or Max Object
		Nome minObject = nomes.stream().min(comparator).get();
		Nome maxObject = nomes.stream().max(comparator).get();
		
		maisFrequente = maxObject;
		
		return maisFrequente;
	}
	
	public  Nome menosFrequenteStream(List<Nome> nomes) {
		if (nomes.size() == 0) {
			throw new RuntimeException("Lista vazia");
		}
		Nome menosFrequente = nomes.get(0);
		Comparator<Nome> comparator = Comparator.comparing( Nome::getFrequencia );
		
		// Get Min or Max Object
		Nome minObject = nomes.stream().min(comparator).get();
		Nome maxObject = nomes.stream().max(comparator).get();

		menosFrequente = minObject;
		
		return menosFrequente;
	}

}
