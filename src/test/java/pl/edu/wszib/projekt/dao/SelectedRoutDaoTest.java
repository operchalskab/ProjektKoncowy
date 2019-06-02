package pl.edu.wszib.projekt.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.wszib.projekt.domain.SelectedRout;

import javax.swing.*;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectedRoutDaoTest {

    public static final String ROUT1 = "a";
    public static final String ROUT2 = "b";

    @Autowired
    SelectedRoutDao selectedRoutDao;

    @Before
    public void setUp() throws Exception {

        SelectedRout selectedRout1 = new SelectedRout(ROUT1, new Date());
        SelectedRout selectedRout2 = new SelectedRout(ROUT2, new Date());

        assertNull(selectedRout1.getId());
        assertNull(selectedRout2.getId());

        selectedRoutDao.save(selectedRout1);
        selectedRoutDao.save(selectedRout2);

        assertNotNull(selectedRout1.getId());
        assertNotNull(selectedRout2.getId());

        System.out.println("---------------------");
    }

    @Test
    public void testFetchAllData(){

        Iterable<SelectedRout> SelectedRouts = selectedRoutDao.findAll();

        int counter =0;
        for (SelectedRout selectedRout : SelectedRouts){
            counter++;
        }
        assertTrue(counter >= 2);
    }

//    @Test
//    public void testFindByRout(){
//
//        List<SelectedRout> selectedRouts = selectedRoutDao.findByRout(ROUT1);
//
//        assertEquals(ROUT1,selectedRouts.get(0).getRout());
//    }
}