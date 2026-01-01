/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maplestory.MagicShield;

public class MagicShield {


    // Instance Variables (Encapsulated)

    private double radius;  
    private double thickness;  
    private String elementType; 


    // Static Variables
    private static final double DEFAULT_RADIUS = 1.0;
    private static final double DEFAULT_THICKNESS = 5.0;
    private static int shieldCount = 0; 

    
    // Constructors

    // No-argument constructor
    public MagicShield() {
        this.radius = DEFAULT_RADIUS;
        this.thickness = DEFAULT_THICKNESS;
        this.elementType = "Neutral";
        shieldCount++; // Increment total shields [cite: 47]
    }

    // Parameterized constructor
    public MagicShield(double radius, double thickness, String elementType) {
        setRadius(radius);
        setThickness(thickness);
        setElementType(elementType);
        shieldCount++; 
    }

    
    // Encapsulation Methods (Getters & Setters

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        // Throw exception if radius is negative
        if (radius < 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
        this.radius = radius;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        // Throw exception if thickness is negative
        if (thickness < 0) {
            throw new IllegalArgumentException("Invalid thickness");
        }
        this.thickness = thickness;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        // If type is null or empty, set to "Neutral" 
        if (elementType == null || elementType.trim().isEmpty()) {
            this.elementType = "Neutral";
        } 
        else {
            this.elementType = elementType;
        }
    }


    // Instance Methods

    public double calculateDefensePower() {
        return calculateDefensePower(this.radius, this.thickness, this.elementType);
    }
    
    public double calculateManaCost() {
        return calculateManaCost(this.radius, this.thickness);
    }


    //  Class Methods (Static)

    public static int getShieldCount() {
        return shieldCount;
    }

    // Checks if a size is valid (non-negative)
    // Since 'double' cannot be null, we only check non-negative.
    public static boolean isValidSize(double size) {
        return size >= 0;
    }


    public static double calculateDefensePower(double radius, double thickness, String elementType) {
        double coefficient = 1.0; 

        if (elementType != null) {
            switch (elementType) {
                case "Fire":
                    coefficient = 1.1; 
                    break;
                case "Ice":
                    coefficient = 1.2; 
                    break;
                case "Light":
                    coefficient = 1.3; 
                    break;
                case "Dark":
                    coefficient = 1.4; 
                    break;
                default:
                    coefficient = 1.0;
                    break;
            }
        }
        return (radius * thickness) * coefficient; 
    }

    public static double calculateManaCost(double radius, double thickness) {
        return (radius * 10) + (thickness * 2); 
    }

    // 7. toString Method
    
    @Override
    public String toString() {
        return String.format(
            "[MagicShield Info]\n" +
            "Element Type: %s\n" +
            "Radius: %.1f m\n" +
            "Thickness: %.1f cm\n" +
            "Defense Power: %.2f\n" +
            "Mana Cost: %.1f",
            elementType, radius, thickness, calculateDefensePower(), calculateManaCost()
        );
    }
}