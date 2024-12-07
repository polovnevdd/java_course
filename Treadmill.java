package overcoming;

public class Treadmill implements Barrier{

    public int LENGTH;

    public Treadmill(int LENGTH){
        this.LENGTH = LENGTH;
    }

    @Override
    public boolean overcome(Participant participant) {
        if(participant.run(LENGTH) == false){
            return false;
        }else{
            return true;
        }
    }
}
