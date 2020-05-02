package lesson0107;

public class Plate {

    private int food;
    private int foodMax;

    public Plate(int food, int foodMax) {
        this.food = food;
        this.foodMax = foodMax;
    }

    public void info() {
        if (food == 0) {
            System.out.println("plate is empty");
        } else {
            System.out.printf("plate : %d\n", food);
        }
    }

//    если в тарелке меньше, чем нужно, то содержимое тарелки не меняется
    boolean decreaseFood(int dF) {
        if (dF > food) {
            return false;
        } else {
            food -= dF;
            return true;
        }
    }

//    если в тарелку пытаются положить еды больше, чем она может в себя вместить,
//    то содержимое тарелки не меняется
    boolean increaseFood(int dF) {
        food += dF;
        if (food > foodMax) {
            food -= dF;
            return false;
        } else {
            return true;
        }
    }
}
