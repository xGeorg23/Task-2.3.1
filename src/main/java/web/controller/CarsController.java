package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImp;

import java.util.Optional;

@Controller
public class CarsController {
    CarServiceImp service = new CarServiceImp();
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(name = "count", required = false) Optional<Integer> count, ModelMap model) {
        model.addAttribute("cars", service.getCars(count.orElse(0)).toString());
        return "cars";
    }
}
