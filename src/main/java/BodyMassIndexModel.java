import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BodyMassIndexModel {

    private double mass;
    private double height;

    public static double calcIndex(double mass, double height) {
        return mass / Math.pow(height, 2);
    }

    public double getIndex() {
        return calcIndex(mass, height);
    }

    public String getRecommendation() {
        String r;
        double i = calcIndex(mass, height);
        if (i < 16) r = "Ты дрищ";
        else if (i < 18.5d) r = "Ты тощий";
        else if (i < 25d) r = "Признайся, что соврал...";
        else if (i < 35d) r = "Ты жирненький";
        else if (i < 40d) r = "Ну ты кабан!";
        else r = "Лучший жир для мыла - человеческий (Чак Паланик)";
        return r;
    }

    public void initBodyMassIndexModel (double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public BodyMassIndexModel(int mass, int height) {
        initBodyMassIndexModel(mass, height);
    }

    public BodyMassIndexModel() {
    }
}
