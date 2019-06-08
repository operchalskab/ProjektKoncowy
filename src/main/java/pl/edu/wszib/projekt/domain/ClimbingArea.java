package pl.edu.wszib.projekt.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "climbing_areas")
public class ClimbingArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String routn;

    @OneToMany
    @JoinColumn(name="climbing_area_id")
    List<SelectedRout> selectedRouts;

    public ClimbingArea() {
    }

    public ClimbingArea(String routn) {
        this.routn = routn;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoutn() {
        return routn;
    }

    public void setRoutn(String routn) {
        this.routn = routn;
    }

    public List<SelectedRout> getSelectedRouts() {
        return selectedRouts;
    }

    public void setSelectedRouts(List<SelectedRout> selectedRouts) {
        this.selectedRouts = selectedRouts;
    }
}


