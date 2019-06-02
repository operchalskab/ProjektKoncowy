package pl.edu.wszib.projekt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "selected_routs")
public class SelectedRout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String rout;
    private Date ctime;

    public SelectedRout() {
    }

    public SelectedRout(String rout, Date ctime) {
        this.rout = rout;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRout() {
        return rout;
    }

    public void setRout(String rout) {
        this.rout = rout;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
