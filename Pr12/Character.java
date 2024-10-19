import java.io.*;

class Character implements Serializable {
    private static final long serialVersionUID = 1L; 
    private String name;
    private int energyLevel;
    private int hungerLevel;
    transient String status;

    public Character(String name) {
        this.name = name;
        this.energyLevel = 100; 
        this.hungerLevel = 0;   
        this.status = "енергійний";
    }

    public void eat(String food) {
        if (food.equals("apple")) {
            energyLevel += 10;
            hungerLevel -= 5;
        } else if (food.equals("sandwich")) {
            energyLevel += 25;
            hungerLevel -= 10;
        }
        updateStatus();
    }

    public void train(String exercise) {
        if (exercise.equals("run")) {
            energyLevel -= 30;
            hungerLevel += 20;
        } else if (exercise.equals("push-ups")) {
            energyLevel -= 15;
            hungerLevel += 10;
        }
        updateStatus();
    }

    public void rest(int hours) {
        energyLevel += hours * 10; 
        updateStatus();
    }

    private void updateStatus() {
        if (energyLevel <= 0) {
            status = "втомлений";
        } else if (hungerLevel >= 100) {
            status = "голодний";
        } else {
            status = "енергійний";
        }
    }

    public void saveCharacter(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Character loadCharacter(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Character) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public String getStatus() {
        return status;
    }
}
