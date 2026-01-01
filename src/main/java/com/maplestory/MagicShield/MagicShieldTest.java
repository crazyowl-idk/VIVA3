package com.maplestory.MagicShield;

public class MagicShieldTest {
    public static void main(String[] args) {

        // 1. Create multiple MagicShield objects using different constructors
        MagicShield shield1 = new MagicShield();
        MagicShield shield2 = new MagicShield(2.0, 8.0, "Fire");
        MagicShield shield3 = new MagicShield(1.5, 6.0, "Ice");

        System.out.println(shield1);
        System.out.println(shield2);
        System.out.println(shield3);

        // 2. Test setters with valid values
        System.out.println("Testing Setters with Valid Values");
        shield1.setRadius(1.2);
        shield1.setThickness(4.5);
        shield1.setElementType("Light");
        System.out.println(shield1);

        // 2. Test setters with invalid values (verify exceptions)
        System.out.println("Testing Setters with Invalid Values");

        try {
            shield1.setRadius(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            shield1.setThickness(-3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 3. Calculate and print defense power and mana cost
        System.out.println("Shield 1 Defense Power: " + shield1.calculateDefensePower());
        System.out.println("Shield 1 Mana Cost: " + shield1.calculateManaCost());

        System.out.println("Shield 2 Defense Power: " + shield2.calculateDefensePower());
        System.out.println("Shield 2 Mana Cost: " + shield2.calculateManaCost() + "\n");

    
        // 4. Use static methods for arbitrary parameters
        double staticDefense = MagicShield.calculateDefensePower(3.0, 10.0, "Dark");
        double staticMana = MagicShield.calculateManaCost(3.0, 10.0);

        System.out.println("Static Defense Power (Dark): " + staticDefense);
        System.out.println("Static Mana Cost: " + staticMana + "\n");

        // 5. Output total number of shields created
        System.out.println("Shield Count: " + MagicShield.getShieldCount() + "\n");

        // 6. Test edge cases
        System.out.println("Is size -1 valid? " + MagicShield.isValidSize(-1));
        System.out.println("Is size 0 valid? " + MagicShield.isValidSize(0));
        System.out.println("Is size 2.5 valid? " + MagicShield.isValidSize(2.5));

        // Test null and empty elementType
        shield1.setElementType(null);
        System.out.println("Element after null input: " + shield1.getElementType());

        shield1.setElementType("");
        System.out.println("Element after empty input: " + shield1.getElementType() + "\n");

        System.out.println("\n===== END OF TEST =====");
    }
}

