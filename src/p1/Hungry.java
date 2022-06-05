package p1;
public class Hungry implements HungerState{
    @Override
    public void doAction(Swimmable swimmable) {
        System.out.println("im hungry");
        swimmable.changeDirToFood();
    }
}
