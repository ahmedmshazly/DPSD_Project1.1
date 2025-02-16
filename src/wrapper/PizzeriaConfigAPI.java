package wrapper;

import java.util.ArrayList;
import model.PizzaConfig;
import model.OptionSet;

/**
 * Concrete API class for configuring pizzerias.
 * Extends ProxyPizzerias and implements both CreatePizzeria and UpdatePizzeria interfaces.
 * Provides methods to create, update, and print pizzeria configurations.
 */
public class PizzeriaConfigAPI extends ProxyPizzerias implements CreatePizzeria, UpdatePizzeria {

    @Override
    public void createPizzerias(String pizzeriaName, ArrayList<PizzaConfig> pizzaConfigs) {
        if (pizzerias.containsKey(pizzeriaName)) {
            System.out.println("Pizzeria '" + pizzeriaName + "' already exists.");
        } else {
            if (!pizzaConfigs.isEmpty()) {
                // For demonstration purposes, we add the first PizzaConfig from the list.
                pizzerias.put(pizzeriaName, pizzaConfigs.get(0));
                System.out.println("Pizzeria '" + pizzeriaName + "' created successfully.");
            } else {
                System.out.println("No pizza configurations provided.");
            }
        }
    }

    @Override
    public void configurePizzeria(String filename) {
        // Stub implementation: In future iterations, implement file I/O here.
        System.out.println("Configuring pizzeria using file: " + filename);
    }

    @Override
    public void printPizzeria(String pizzeriaName) {
        PizzaConfig config = pizzerias.get(pizzeriaName);
        if (config != null) {
            config.print();
        } else {
            System.out.println("Pizzeria '" + pizzeriaName + "' not found.");
        }
    }

    @Override
    public void updateOptionSetName(String pizzeriaName, String optionSetName, String newName) {
        PizzaConfig config = pizzerias.get(pizzeriaName);
        if (config != null) {
            OptionSet os = config.findOptionSet(optionSetName);
            if (os != null) {
                os.setName(newName);
                System.out.println("OptionSet name updated successfully.");
            } else {
                System.out.println("OptionSet '" + optionSetName + "' not found.");
            }
        } else {
            System.out.println("Pizzeria '" + pizzeriaName + "' not found.");
        }
    }

    @Override
    public void updateBasePrice(String pizzeriaName, double newPrice) {
        PizzaConfig config = pizzerias.get(pizzeriaName);
        if (config != null) {
            config.setBasePrice(newPrice);
            System.out.println("Base price updated successfully.");
        } else {
            System.out.println("Pizzeria '" + pizzeriaName + "' not found.");
        }
    }

    @Override
    public void updateOptionPrice(String pizzeriaName, String optionSetName, String optionName, double newPrice) {
        PizzaConfig config = pizzerias.get(pizzeriaName);
        if (config != null) {
            OptionSet os = config.findOptionSet(optionSetName);
            if (os != null) {
                boolean updated = os.updateOption(optionName, newPrice);
                if (updated) {
                    System.out.println("Option price updated successfully.");
                } else {
                    System.out.println("Option '" + optionName + "' not found in OptionSet '" + optionSetName + "'.");
                }
            } else {
                System.out.println("OptionSet '" + optionSetName + "' not found.");
            }
        } else {
            System.out.println("Pizzeria '" + pizzeriaName + "' not found.");
        }
    }
}
