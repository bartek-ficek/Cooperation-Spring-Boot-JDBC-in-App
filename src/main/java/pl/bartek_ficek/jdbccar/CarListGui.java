package pl.bartek_ficek.jdbccar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class CarListGui extends VerticalLayout {

    private CarDao carDao;
    private TextField textFieldCarMake;
    private TextArea textAreaListOfCars;
    private Button button;

    @Autowired
    public CarListGui(CarDao carDao) {
        this.textFieldCarMake = new TextField("Car make");
        this.textAreaListOfCars = new TextArea("List of Cars");
        this.button = new Button("Show cars");

        add(textFieldCarMake, textAreaListOfCars, button);
        button.addClickListener(clickEvent -> {
           textAreaListOfCars.setValue(String.valueOf(carDao.showByCarMaker(textFieldCarMake.getValue())));
        });
    }
}
