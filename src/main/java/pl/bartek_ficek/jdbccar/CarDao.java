package pl.bartek_ficek.jdbccar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String sql = "CREATE TABLE Car(car_id int, make varchar(255), model varchar(255), color varchar(255));";
        jdbcTemplate.update(sql);
    }
    
    public void add(Car car) {
        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
            jdbcTemplate.update(sql, new Object[] {
                car.getCarId(),
                car.getCarMake(),
                car.getModel(),
                car.getColor()
        });
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
//        Call below method only with first use of Application. After first use, table became created
//        createTable();
        add(new Car(1,"Fiat", "Punto", "Orange"));
        add(new Car(1,"Fiat", "125p", "White"));
        add(new Car(1,"Ford", "Fiesta", "Blue"));
        add(new Car(1,"Volkswagen", "Polo", "Violet"));
    }
}