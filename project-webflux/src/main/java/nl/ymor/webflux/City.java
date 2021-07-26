package nl.ymor.webflux;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class City {

    @Id
    private long id;
    private String name;
    private String countrycode;
    private String district;
    private long population;

}