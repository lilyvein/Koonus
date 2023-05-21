import java.util.Random;
import java.util.Scanner;

public class Cone {
    private final double height;
    private final double diameter;
    private final double radius;

    public Cone(double height) {
        this.height = height;
        Random random = new Random();
        this.diameter = random.nextDouble() * 10; // Juhuslik diameeter vahemikus 0 kuni 10
        this.radius = calculateRadius();
    }

    public double calculateRadius() {
        return diameter / 2;
    }

    public double calculateBaseSurfaceArea() {  // Ümbermõõt B = πr2
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateSlantHeight() {  // Moodustaja  s = √(r2 + h2)
        return Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
    }

    public double calculateLateralSurfaceArea() { // Külje pindala L = πrs
        double slantHeight = calculateSlantHeight();
        return Math.PI * radius * slantHeight;
    }

    public double calculateSurfaceArea() {  // Pindala A = L + B
        double lateralSurfaceArea = calculateLateralSurfaceArea();
        double baseSurfaceArea = calculateBaseSurfaceArea();
        return lateralSurfaceArea + baseSurfaceArea;
    }

    public double calculateVolume() {  //  Ruumala  V = (1/3)πr2h
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    public static void main(String[] args) {
        // Küsi kasutajalt koonuse kõrgus
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sisesta koonuse kõrgus cm: ");
        double height = scanner.nextDouble();

        // Loome koonuse objekti
        Cone cone = new Cone(height);

        // kuvage tulemused
        double surfaceArea = cone.calculateSurfaceArea();
        double radius = cone.calculateRadius();
        double volume = cone.calculateVolume();
        double slantHeight = cone.calculateSlantHeight();
        double lateralSurfaceArea = cone.calculateLateralSurfaceArea();

        System.out.printf("Koonuse kõrgus on: %.2f%n", height);
        System.out.printf("Koonuse diameeter on: %.2f%n", cone.diameter);
        System.out.printf("Koonuse raadius on: %.2f%n", radius);
        System.out.printf("Koonuse pindala on: %.2f%n", surfaceArea);
        System.out.printf("Koonuse ruumala on: %.2f%n", volume);
        System.out.printf("Koonuse külgserva pikkus on: %.2f%n", slantHeight);
        System.out.printf("Koonuse külgpindala on: %.2f%n", lateralSurfaceArea);
    }
}
