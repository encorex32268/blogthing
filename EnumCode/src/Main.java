public class Main {


    private enum Action{
        UP,DOWN,LEFT,RIGHT;

    }

    public static void main(String[] args) {

       doAction(Action.DOWN);
    }

    private static void doAction(Action action) {
        switch (action)
        {
            case UP:
                //doSomething
                System.out.println("UP");
                break;
            case DOWN:
                //doSomething
                System.out.println("DOWN");
                break;
            case LEFT:
                //doSomething
                System.out.println("LEFT");
                break;
            case RIGHT:
                //doSomething
                System.out.println("RIGHT");
                break;
        }
    }
}
