package za.ac.cput.recipesearcher.Entities;

import za.ac.cput.recipesearcher.Entities.Util.Macros;

public class Ingredient {
    private String ingredientName;
    //--all possible quantities
    //mililitres
    private String ingredientQuantity;
    //liquid or powder, etc.
    private String ingredientType;

    private Macros macros;

    public Ingredient(IngredientBuilder ingredientBuilder) {
        this.ingredientName = ingredientBuilder.ingredientName;
        this.ingredientQuantity = ingredientBuilder.ingredientQuantity;
        this.ingredientType = ingredientBuilder.ingredientType;
        this.macros = ingredientBuilder.macros;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public String getIngredientQuantity() {
        return ingredientQuantity;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public Macros getMacros() {
        return macros;
    }

    public static class IngredientBuilder{
        public static String ingredientName;
        public static String ingredientQuantity;
        public static String ingredientType;
        private static Macros macros;

        public IngredientBuilder(String ingredientName, String ingredientQuantity, String ingredientType, Macros macros) {
            this.ingredientName = ingredientName;
            this.ingredientQuantity = ingredientQuantity;
            this.ingredientType = ingredientType;
            this.macros = macros;
        }

        public Ingredient build(){
            return new Ingredient(this);
        }
    }
}
