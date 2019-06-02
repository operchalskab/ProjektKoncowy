package pl.edu.wszib.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.projekt.dao.SelectedRoutDao;
import pl.edu.wszib.projekt.domain.SelectedRout;

@Controller
public class DataController {

    @Value("${app.header.data}")
    private String title;

    @Autowired
    SelectedRoutDao selectedRoutDao;

    @GetMapping("/data")
    public String dataPage(Model model){
    Iterable<SelectedRout> selectedRouts = selectedRoutDao.findAll();

        model.addAttribute("title", title);
        model.addAttribute("selectedRouts", selectedRouts);
        return "data";
    }
}
