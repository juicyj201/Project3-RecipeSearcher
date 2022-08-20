package za.ac.cput.recipesearcher.Entities.Util;

public class Macros {
    private int totalProtein;
    private int totalCarbs;
    private int totalFat;
    private int totalFibre;

    public Macros(int totalProtein, int totalCarbs, int totalFat, int totalFibre) {
        this.totalProtein = totalProtein;
        this.totalCarbs = totalCarbs;
        this.totalFat = totalFat;
        this.totalFibre = totalFibre;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(int totalProtein) {
        this.totalProtein = totalProtein;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(int totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public int getTotalFibre() {
        return totalFibre;
    }

    public void setTotalFibre(int totalFibre) {
        this.totalFibre = totalFibre;
    }

    @Override
    public String toString() {
        return "Macros{" +
                "totalProtein=" + totalProtein +
                ", totalCarbs=" + totalCarbs +
                ", totalFat=" + totalFat +
                ", totalFibre=" + totalFibre +
                '}';
    }
}
