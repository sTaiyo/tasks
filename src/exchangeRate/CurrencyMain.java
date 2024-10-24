package exchangeRate;

public class CurrenciesMain {
    public static void main(String[] args) {
        CurrencyDisplay display = new CurrencyDisplay();
        СurrencyConverter converter = new СurrencyConverter();

        display.printInfo();

        converter.inputCurrency = display.getInputCurrency();
        if (converter.getRate(converter.inputCurrency) == 0.0) {
            display.invalidInput();
            System.exit(-1);
        }
        converter.currencyValue = Math.abs(display.getInputCurrencyValue());

        double[] results = converter.exchangeValue(converter.getRate(converter.inputCurrency), converter.currencyValue);

        display.printResults(converter.currencyValue, converter.inputCurrency, results, converter.getCurrencies());
    }
}
