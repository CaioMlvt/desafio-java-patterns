package lab.designpattern.gof.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ExternalProductDTO {

    @JsonProperty("title")
    private String name;

    private Double price;



}
