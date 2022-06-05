package p1;

public class Satiated implements HungerState{
    @Override
    public void doAction(Swimmable swimmable) {
        System.out.println("im satiated");
        if (swimmable.hungerCounter < 4){
            swimmable.setHungerCounter(swimmable.getHungerCounter()+1);
        }else {
            swimmable.setHungerCounter(0);
            swimmable.setHungerState(new Hungry());
        }
    }
}
