package za.ac.cput.recipesearcher.Entities;

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

    public Ingredient(IngredientBuilder ingredientBuilder) {
        this.ingredientName = ingredientBuilder.ingredientName;
        this.ingredientQuantityML = ingredientBuilder.ingredientQuantityML;
        this.ingredientQauntityG = ingredientBuilder.ingredientQuantityG;
        this.ingredientQuantityC = ingredientBuilder.ingredientQuantityC;
        this.ingredientType = ingredientBuilder.ingredientType;
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

    public static class IngredientBuilder{
        public static String ingredientName;
        public static int ingredientQuantityML;
        public static int ingredientQuantityG;
        public static int ingredientQuantityC;
        public static String ingredientType;

        public IngredientBuilder(String ingredientName, int ingredientQuantityML, int ingredientQuantityG, int ingredientQuantityC, String ingredientType) {
            this.ingredientName = ingredientName;
            this.ingredientQuantityML = ingredientQuantityML;
            this.ingredientQuantityG = ingredientQuantityG;
            this.ingredientQuantityC = ingredientQuantityC;
            this.ingredientType = ingredientType;
        }

        public Ingredient build(){
            return new Ingredient(this);
        }
    }
}
