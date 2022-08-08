import java.util.HashMap;

public class FirstQuestion {

	public static void main(String[] args) {
		DisplayCountryCapitalMap countryMap = new DisplayCountryCapitalMap();

		countryMap.saveCountryCapital("India", "Delhi");
		countryMap.saveCountryCapital("Japan", "Tokyo");
		countryMap.saveCountryCapital("England", "London");
		countryMap.saveCountryCapital("Nepal", "Kathmandu");

		
		System.out.println(countryMap.getCapital("India"));
		System.out.println(countryMap.getCountry("Tokyo"));
		System.out.println(countryMap.toArrayList());
		
		HashMap<String, String> M2 = countryMap.swapKeyValue();
		System.out.println(M2);
	}

}