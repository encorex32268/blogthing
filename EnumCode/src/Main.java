public class Main {


    private enum Action{
        UP("¤W"),DOWN("¤U"),LEFT("¥ª"),RIGHT("¥k");

        private final String string ;

        Action(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }
    }


    public static void main(String[] args) {

       for(Action action : Action.values())
        {
            System.out.println(action.getString());
        }
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
