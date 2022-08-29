package za.ac.cput.recipesearcher.Entities;

import za.ac.cput.recipesearcher.Entities.Util.Macros;

public class Ingredient {
    private String ingredientName;
    //--all possible quantities
    //mililitres
    private int ingredientQuantityML;
    //grams
    private int ingredientQauntityG;
    //cups
    private int ingredientQuantityC;
    //liquid or powder, etc.
    private String ingredientType;

    private Macros macros;

    public Ingredient(IngredientBuilder ingredientBuilder) {
        this.ingredientName = ingredientBuilder.ingredientName;
        this.ingredientQuantityML = ingredientBuilder.ingredientQuantityML;
        this.ingredientQauntityG = ingredientBuilder.ingredientQuantityG;
        this.ingredientQuantityC = ingredientBuilder.ingredientQuantityC;
        this.ingredientType = ingredientBuilder.ingredientType;
        this.macros = ingredientBuilder.macros;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public int getIngredientQuantityML() {
        return ingredientQuantityML;
    }

    public int getIngredientQauntityG() {
        return ingredientQauntityG;
    }

    public int getIngredientQuantityC() {
        return ingredientQuantityC;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public Macros getMacros() {
        return macros;
    }

    public static class IngredientBuilder{
        public static String ingredientName;
        public static int ingredientQuantityML;
        public static int ingredientQuantityG;
        public static int ingredientQuantityC;
        public static String ingredientType;
        private static Macros macros;

        public IngredientBuilder(String ingredientName, int ingredientQuantityML, int ingredientQuantityG, int ingredientQuantityC, String ingredientType, Macros macros) {
            this.ingredientName = ingredientName;
            this.ingredientQuantityML = ingredientQuantityML;
            this.ingredientQuantityG = ingredientQuantityG;
            this.ingredientQuantityC = ingredientQuantityC;
            this.ingredientType = ingredientType;
            this.macros = macros;
        }

        public Ingredient build(){
            return new Ingredient(this);
        }
    }
}
