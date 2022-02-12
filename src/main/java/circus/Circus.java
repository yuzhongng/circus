package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        System.out.println("Number of animals in the array list: " + animalArrayList.size());
        animalArrayList.add(new Duck("Goose"));
        animalArrayList.add(new Parrot("Dolly"));
        System.out.println("Number of animals in the array list: " + animalArrayList.size());
        printAllAnimals(animalArrayList);

        Duck louie = new Duck("Louie");
        Elephant strongOne = new Elephant("StrongOne");
        Parrot andy = new Parrot("Andy");

        animalArrayList.add(louie);
        animalArrayList.add(strongOne);
        animalArrayList.add(andy);
        printAllAnimals(animalArrayList);

        System.out.println("Position of Louie is : " + (animalArrayList.indexOf(louie) + 1));
        System.out.println();
        System.out.println("Before sorting");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After sorting:");
        printAllAnimals(animalArrayList);
        System.out.println("Position of Louie is : " + (animalArrayList.indexOf(louie) + 1));

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        duckCage.lockUp(louie);

        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(andy);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        Cage<Elephant> elephantCage = new Cage<>();
        elephantCage.lockUp(strongOne);

        cages.add(elephantCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
