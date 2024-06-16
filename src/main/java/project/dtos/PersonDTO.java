package project.dtos;

import project.entity.GasStation;
import project.entity.Person;

import java.util.List;

public class PersonDTO {
    private int id;
    private String name;
    private int age;
    private CarDTO carDTO;
    private List<GasStationDTO> gasStationDTOList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
        this.carDTO = carDTO;
    }

    public List<GasStationDTO> getGasStationDTOList() {
        return gasStationDTOList;
    }

    public void setGasStationDTOList(List<GasStationDTO> gasStationDTOList) {
        this.gasStationDTOList = gasStationDTOList;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
