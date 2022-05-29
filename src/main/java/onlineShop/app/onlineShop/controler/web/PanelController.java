package onlineShop.app.onlineShop.controler.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PanelController {

    @GetMapping("/panel")
    public String panel(){
        return "panel";
    }
}
