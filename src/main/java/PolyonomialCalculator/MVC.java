// creates and combines the three main components: Model, Controller and View

import java.util.regex.*;

public class MVC {
    public static void main(String [] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
