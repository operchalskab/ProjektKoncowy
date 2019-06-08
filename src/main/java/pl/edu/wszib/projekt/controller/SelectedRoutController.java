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

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@Controller
public class SelectedRoutController {

    @Value("${app.header.select_rout}")
    private String title;


    @Autowired
    SelectedRoutDao selectedRoutDao;

        @GetMapping({"/select","/select/{rout}"})
        public String selectRoutPage(@PathVariable(required = false) String rout, Model model){

            if (!StringUtils.isEmpty(rout)){
                selectedRoutDao.save(new SelectedRout(rout,new Date()));
            }

            String [] routs = {"Ex libris" , "Ja nie latam", "Blondynka", "Luz Bluszcz", "Schodki", "Zemsta"};
//            List<String> routs = new ArrayList<>();
//            routs.add("Ex Libris");
//            routs.add("Ja nie latam");


        model.addAttribute("title", title);
        model.addAttribute("routs", routs);

        return "select";
    }


}
