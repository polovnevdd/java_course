package overcoming;

public class Wall implements Barrier{

    public int HEIGHT;

    public Wall(int HEIGHT){
        this.HEIGHT = HEIGHT;
    }

    @Override
    public boolean overcome(Participant participant) {
        if(participant.jump(HEIGHT) == false){
            return false;
        }else{
            return true;
        }
    }
}
