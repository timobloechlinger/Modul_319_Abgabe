public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("BMW");
        Auto auto2 = new Auto();

        auto1.showBrand();
        auto2.showBrand();
    }
}
public class Auto {
    private String brand;

    public Auto() {
        this.brand = "Unbekannt";
    }

    public Auto(String brand) {
        this.brand = (brand != null && !brand.isBlank()) ? brand : "Unbekannt";
    }

    public void showBrand() {
        System.out.println(this.brand);
    }
}