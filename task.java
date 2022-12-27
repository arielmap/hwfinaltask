import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class task {

    static List<Laptop> shoplaptop;

    public static void main(String[] args) {

        shoplaptop = new LinkedList<Laptop>();

        shoplaptop.add(new Laptop(1, 2, 128, "Windows XP", "черный"));
        shoplaptop.add(new Laptop(1, 4, 256, "Windows 7", "белый"));
        shoplaptop.add(new Laptop(1, 16, 512, "Windows 10", "серебристый"));
        shoplaptop.add(new Laptop(1, 32, 1024, "Windows 11", "черный"));

        final String no_laptops = "\n У нас таких ноутбуков нет :(\n";

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Добро пожаловать в магазин ноутбуков!");
            System.out.println("1 - поиск по объему оперативной памяти");
            System.out.println("2 - поиск по объему накопителя");
            System.out.println("3 - поиск по операционной системе");
            System.out.println("4 - выход");

            choice = sc.nextInt();
            System.out.println();
            int n = 0;
            StringBuilder founded = new StringBuilder();
            if (choice == 1) {
                System.out.println("Какой минимальный объем оперативной памяти вам нужен?");
                int ram = sc.nextInt();
                for (Laptop laptop : shoplaptop) {
                    if (laptop.ram >= ram) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            } else if (choice == 2) {
                System.out.println("Какой минимальный объем накопителя вам нужен?");
                int hdd = sc.nextInt();
                for (Laptop laptop : shoplaptop) {
                    if (laptop.hdd >= hdd) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Какая операционная система для вас предпочтительна?");
                String os = sc2.nextLine();
                for (Laptop laptop : shoplaptop) {
                    if (os.equals(laptop.os)) {
                        founded.append(laptop.toString()).append("\n");
                        n++;
                    }
                }
            } else if (choice == 4) {
                break;
            }
            if (n == 0) {
                System.out.println(no_laptops);
            } else {
                System.out.println("\nНайдены следующие варианты:\n\n" + founded);
            }
        }
        sc.close();
        sc2.close();
    }

}

class Laptop {

    int id;
    int ram;
    int hdd;
    String os;
    String color;

    public Laptop(int id, int ram, int ssd, String os, String color) {
        this.id = id;
        this.ram = ram;
        this.hdd = ssd;
        this.os = os;
        this.color = color;
    }

    public String toString() {
        return String.format("id: %d, ram: %d ГБ, ssd: %d ГБ, OS: %s, color: %s", id, ram, hdd, os, color);
    }

}