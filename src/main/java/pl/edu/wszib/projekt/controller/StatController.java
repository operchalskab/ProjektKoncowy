package pl.edu.wszib.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.projekt.dao.SelectedRoutDao;
import pl.edu.wszib.projekt.domain.SelectedRout;
import pl.edu.wszib.projekt.hellper.RoutHelper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Value("${app.header.stat}")
    private String title;

    @Autowired
    SelectedRoutDao selectedRoutDao;

    @GetMapping("/stat")
    public String statRoutPage(Model model){

        Iterable<SelectedRout> selectedRouts = selectedRoutDao.findAll();
        Collection<SelectedRout> selectedRoutCollection = (Collection<SelectedRout>)selectedRouts;
        Map<String,Long> dataMap = selectedRoutCollection.stream()
                .collect(Collectors.groupingBy(SelectedRout::getRout,Collectors.counting()));

        List<String> labels = RoutHelper.convertRouts(dataMap.keySet());

        model.addAttribute("title", title);
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("labels", labels);

        return "stat";
    }

}
