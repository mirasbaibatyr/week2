package Gym_system;

public class FitnessClass {
    private int id;
    private String name;
    private Gym_system.Trainers trainer;
    private int maxParticipants;
    private int currentParticipants = 0;

    public FitnessClass(int id, String name, Gym_system.Trainers trainer, int maxParticipants) {
        this.id = id;
        this.name = name;
        this.trainer = trainer;
        this.maxParticipants = maxParticipants;
    }

    public boolean bookSpot() {
        if (currentParticipants < maxParticipants) {
            currentParticipants++;
            System.out.println("Booking successful for " + this.name);
            return true;
        } else {
            System.out.println("Class " + this.name + " is full.");
            return false;
        }
    }

    public int getVacancyCount() {
        return maxParticipants - currentParticipants;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Gym_system.Trainers getTrainer() { return trainer; }
    public int getMaxParticipants() { return maxParticipants; }
    public int getCurrentParticipants() { return currentParticipants; } // Getter for new field

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setTrainer(Gym_system.Trainers trainer) { this.trainer = trainer; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public String toString() {
        return "Gym_system.FitnessClass{id=" + id + ", name='" + name + "', trainer=" + trainer.getName() +
                ", enrolled=" + currentParticipants + "/" + maxParticipants + "}";
    }
}
