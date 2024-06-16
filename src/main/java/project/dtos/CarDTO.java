package project.dtos;

public class CarDTO {
    private int id;
    private Long personId;
    private String model;
    private int horsePower;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", personId=" + personId +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }
}