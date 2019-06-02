package pl.edu.wszib.projekt.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.thymeleaf.util.StringUtils;
        import pl.edu.wszib.projekt.dao.SelectedRoutDao;
        import pl.edu.wszib.projekt.domain.SelectedRout;

        import java.util.Date;

@Controller
public class SelectedRoutController {

    @Value("${app.header.select_rout}")
    private String title;

//    @GetMapping("/select")
//    public String selectRoutPage(Model model){

    @Autowired
    SelectedRoutDao selectedRoutDao;

        @GetMapping({"/select","/select/{rout}"})
        public String selectRoutPage(@PathVariable(required = false) String rout, Model model){

            if (!StringUtils.isEmpty(rout)){
            selectedRoutDao.save(new SelectedRout(rout, new Date()));
            }

        String [][] routs = {{"yelow", "red"},
                {"black", "blue"}};

        model.addAttribute("title", title);
        model.addAttribute("routs", routs);

        return "select";
    }

    @GetMapping("/stat")
    public String statRoutPage(){
        return "stat";
    }

//    @GetMapping("/data")
//    public String dataRoutPage(Model model){
//    Iterable<SelectedRout> selectedRouts = selectedRoutDao.findAll();
//
//
//
//        return "data";
//    }
}
