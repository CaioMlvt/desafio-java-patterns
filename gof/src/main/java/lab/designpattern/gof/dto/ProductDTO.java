package lab.designpattern.gof.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O preço é obrigatório")
    private Double price;


    public @NotBlank(message = "O nome é obrigatório") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "O nome é obrigatório") String name) {
        this.name = name;
    }

    public @NotNull(message = "O preço é obrigatório") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "O preço é obrigatório") Double price) {
        this.price = price;
    }
}