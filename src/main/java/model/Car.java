package model;


public class Car {
    private int id;
    private int userId;
    private String model;
    private String colour;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", userId=" + userId +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (userId != car.userId) return false;
        if (!model.equals(car.model)) return false;
        return colour.equals(car.colour);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + model.hashCode();
        result = 31 * result + colour.hashCode();
        return result;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Car() {
    }
    public Car(int id, int userId, String model) {
        this.id = id;
        this.userId = userId;
        this.model = model;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}

