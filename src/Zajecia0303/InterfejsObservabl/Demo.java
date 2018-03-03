package Zajecia0303.InterfejsObservabl;

import Zajecia0303.InterfejsObservabl.StacjaPogodowa.WeatherData;
import Zajecia0303.InterfejsObservabl.Wyswietlacze.CurrentReadingsScreen; 

public class Demo {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentReadingsScreen currentReadingsScreen = new CurrentReadingsScreen(weatherData);
		
		weatherData.setReadings(10.0f, 90, 1015.10f);
		weatherData.checkReadings();
		currentReadingsScreen.printData();
		weatherData.setReadings(11.0f, 85, 1010.10f);
		weatherData.checkReadings();
		currentReadingsScreen.printData();
	}
}
