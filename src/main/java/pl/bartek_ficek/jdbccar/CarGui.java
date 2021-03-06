package pl.bartek_ficek.jdbccar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class CarGui extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldCarMake;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        this.textFieldId = new TextField("Id");
        this.textFieldCarMake = new TextField("Car Make");
        this.textFieldModel = new TextField("Model");
        this.textFieldColor = new TextField("Color");
        this.button = new Button("Add car");
        this.carDao = carDao;

        //TODO validation
        add(textFieldId, textFieldCarMake, textFieldModel, textFieldColor, button);
        button.addClickListener(clickEvent -> {
            Car car = new Car(Long.parseLong(textFieldId.getValue()),textFieldCarMake.getValue(),textFieldModel.getValue(),textFieldColor.getValue());
            carDao.save(car);
        });
    }
}
