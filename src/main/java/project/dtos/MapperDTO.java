package project.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import project.entity.Car;
import project.entity.GasStation;
import project.entity.Person;

@Mapper
public interface MapperDTO {
    MapperDTO INSTANCE = Mappers.getMapper(MapperDTO.class);

    @Mapping(source = "person.id", target = "personId")
    CarDTO carToCarDTO(Car car);

    @Mapping(source = "personId", target = "person.id")
    Car carDTOToCar(CarDTO carDTO);

    @Mapping(target = "carDTO", source = "car")
    @Mapping(target = "gasStationDTOList", source = "stationList")
    PersonDTO personToPersonDTO(Person person);

    @Mapping(target = "car", source = "carDTO")
    @Mapping(target = "stationList",source = "gasStationDTOList")
    Person personDTOToPerson(PersonDTO personDTO);

    @Mapping(target = "personDTOList", ignore = true)
    GasStationDTO gasStationToGasStationDTO(GasStation gasStation);

    @Mapping(target = "personList", ignore = true)
    GasStation gasStationDTOToGasStation(GasStationDTO gasStationDTO);
}
