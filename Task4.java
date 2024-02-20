// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import org.json.JSONObject;




// //Task 3 Is not complete. So Submit the task 1 to 4




Task 


// class CurrencyConverter {
//     private static final String API_KEY = "ddeebb119c33c37de64624d5";
//     private static final String API_URL = "https://v6.exchangerate-api.com/v6/ddeebb119c33c37de64624d5/latest/USD";

//     public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
//         URL url = new URL(API_URL + baseCurrency);
//         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//         connection.setRequestMethod("GET");

//         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//         StringBuilder response = new StringBuilder();
//         String line;
//         while ((line = reader.readLine()) != null) {
//             response.append(line);
//         }
//         reader.close();

//         JSONObject jsonResponse = new JSONObject(response.toString());
//         return jsonResponse.getJSONObject("rates").getDouble(targetCurrency);
//     }

//     public static double convertCurrency(double amount, double exchangeRate) {
//         return amount * exchangeRate;
//     }
// }

// public class CurrencyConverterApp {
//     public static void main(String[] args) {
//         try {
//             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//             // Currency Selection
//             System.out.print("Enter the base currency code (e.g., USD): ");
//             String baseCurrency = reader.readLine().toUpperCase();
//             System.out.print("Enter the target currency code (e.g., EUR): ");
//             String targetCurrency = reader.readLine().toUpperCase();

//             // Currency Rates
//             double exchangeRate = CurrencyConverter.getExchangeRate(baseCurrency, targetCurrency);
//             System.out.println("Exchange Rate: 1 " + baseCurrency + " = " + exchangeRate + " " + targetCurrency);

//             // Amount Input
//             System.out.print("Enter the amount to convert: ");
//             double amount = Double.parseDouble(reader.readLine());

//             // Currency Conversion
//             double convertedAmount = CurrencyConverter.convertCurrency(amount, exchangeRate);

//             // Display Result
//             System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
