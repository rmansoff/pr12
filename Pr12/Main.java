import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Завдання 1: Серіалізація та десеріалізація Person
        Person person = new Person("Іван", 25, "Київ");
        String personFilePath = "person.ser";
        person.savePerson(personFilePath);

        Person loadedPerson = Person.loadPerson(personFilePath);
        if (loadedPerson != null) {
            System.out.println("Person Data:");
            System.out.println("Name: " + loadedPerson.getName());
            System.out.println("Age: " + loadedPerson.getAge());
            System.out.println("City: " + loadedPerson.getCity());
        }

        // Завдання 2: Серіалізація та десеріалізація Character
        String characterFilePath = "character.ser";
        Character character;

        File characterFile = new File(characterFilePath);
        if (characterFile.exists()) {
            // Десеріалізація
            character = Character.loadCharacter(characterFilePath);
            System.out.println("Character Data (loaded):");
            System.out.println("Name: " + character.getName());
            System.out.println("Energy Level: " + character.getEnergyLevel());
            System.out.println("Hunger Level: " + character.getHungerLevel());

            // Виконання дій
            character.rest(1);  // Відпочити 1 годину
            character.eat("apple");
            character.train("run");
        } else {
            // Створення нового персонажа
            character = new Character("Герой");
            character.eat("sandwich");
            character.train("push-ups");
            character.eat("apple");
            character.rest(2);  // Відпочити 2 години
            character.train("run");
        }

        // Виведення властивостей персонажа
        System.out.println("Character Data (after actions):");
        System.out.println("Name: " + character.getName());
        System.out.println("Energy Level: " + character.getEnergyLevel());
        System.out.println("Hunger Level: " + character.getHungerLevel());
        System.out.println("Status: " + character.getStatus());

        // Серіалізація персонажа
        character.saveCharacter(characterFilePath);
    }
}
