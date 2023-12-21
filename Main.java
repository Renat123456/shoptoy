import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Toy> toys = new ArrayList<>();
    public static void main(String[] args) {

        Boolean flag = true;
        while (flag) {
            System.out.println("Введите 1 чтобы добавить игрушку");
            System.out.println("Введите 2 чтобы посмотреть все игрушки");
            System.out.println("Введите 3 чтобы получить игрушку");
            System.out.println("Введите 4 чтобы завершить программу");

            Scanner in = new Scanner(System.in);
            String command = in.nextLine();

            if (command.equals("1")) {
                addToy();
            }
            if (command.equals("2")) {
                showToys();
            }
            if (command.equals("3")) {
                getToy();
            }
            if (command.equals("4")) {
                flag = false;
            }
        }
    }

    private static void addToy() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название игрушки");
        String toyName = in.nextLine();
        System.out.println("Введите шанс выпадения игрушки от 0 до 100");
        String chanceStr = in.nextLine();
        int chance = Integer.parseInt(chanceStr);
        Toy toy = new Toy(toyName, chance);
        toys.add(toy);
    }

    private static void showToys() {
        for (int i = 0; i < toys.size(); i++) {
            System.out.println(toys.get(i));
        }
    }

    private static void getToy() {
        int allChance = 0;
        int allChanceRandom = 0;
        Toy toy;
        for (int i = 0; i < toys.size(); i++) {
            toy = toys.get(i);
            allChance += toy.getChance();
        }
        int randomToy = (int) (Math.random() * allChance);
        for (int i = 0; i < toys.size(); i++) {
            toy = toys.get(i);
            allChanceRandom += toy.getChance();
            if(randomToy < allChanceRandom){
                System.out.println("Поздравляем вы выиграли " + toy.getNameToy());
                toys.remove(i);
                break;
            }
        }
    }
}