package com.example.demo.config;
import com.example.demo.dto.RatingRequestDTO;
import com.example.demo.dto.RestaurantRequestDTO;
import com.example.demo.dto.VisitorRequestDTO;
import com.example.demo.service.RatingService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.VisitorService;
import com.example.demo.model.CuisineType;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final RatingService ratingService;

    @PostConstruct
    public void init() {

        // Добавление посетителей 
        visitorService.create(new VisitorRequestDTO("Sasha", 25, "М"));
        visitorService.create(new VisitorRequestDTO(null, 35, "Ж"));

        // Добавление ресторанов
        restaurantService.create(new RestaurantRequestDTO(
                "Sakura",
                "",
                CuisineType.JAPANESE,
                new BigDecimal("500")
        ));

        restaurantService.create(new RestaurantRequestDTO(
                "Lo Scoglio",
                "Итальянская кухня",
                CuisineType.ITALIAN,
                new BigDecimal("1500")
        ));

        // Добавление отзывов
        ratingService.create(new RatingRequestDTO(1L, 1L, 3, "Нормально"));
        ratingService.create(new RatingRequestDTO(2L, 1L, 4, ""));
        ratingService.create(new RatingRequestDTO(1L, 2L, 5, "Отлично!"));

        // API
        System.out.println("\nВсе посетители:");
        visitorService.getAll().forEach(System.out::println);

        System.out.println("\nВсе рестораны:");
        restaurantService.getAll().forEach(System.out::println);

        System.out.println("\nВсе оценки:");
        ratingService.getAll().forEach(System.out::println);
    }
}