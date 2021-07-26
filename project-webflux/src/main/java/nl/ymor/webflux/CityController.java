package nl.ymor.webflux;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/city")
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping
    public Flux<City> getAll() {
        return cityRepository.findAll();
    }

}
