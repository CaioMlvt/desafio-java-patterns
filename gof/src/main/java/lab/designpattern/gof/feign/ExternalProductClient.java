package lab.designpattern.gof.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "externalProducts", url = "https://fakestoreapi.com")
public interface ExternalProductClient {

    @GetMapping("/products")
    List<ExternalProductDTO> getProducts();

}
