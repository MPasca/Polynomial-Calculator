package PolyonomialCalculator;// creates and combines the three main components: PolyonomialCalculator.Model, PolyonomialCalculator.Controller and PolyonomialCalculator.View

public class MVC {
    public static void main(String [] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
