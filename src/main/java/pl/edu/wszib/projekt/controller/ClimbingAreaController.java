package pl.edu.wszib.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.projekt.dao.ClimbingAreaDao;
import pl.edu.wszib.projekt.dao.SelectedRoutDao;
import pl.edu.wszib.projekt.domain.ClimbingArea;
import pl.edu.wszib.projekt.domain.SelectedRout;

@Controller
public class ClimbingAreaController {

    @Value("${app.header.area}")
    private String title;

    @Autowired
    ClimbingAreaDao climbingAreaDao;


    @GetMapping("/asdf")
    public String areasPage(@PathVariable(required = false) String routn, Model model) {

    climbingAreaDao.save(new ClimbingArea(routn));


//    climbingAreaDao.save(new ClimbingArea("Dolina Bolechowickaadfa"));
//    climbingAreaDao.save(new ClimbingArea("Dolina Będkowfdfdska"));

    String [] routns = {"Dolina Bolichowicka" , "Dolina_Bedkowska"};

    model.addAttribute("title",title);
    model.addAttribute("climbingArea", routns);
    return "asdf";
    }
}