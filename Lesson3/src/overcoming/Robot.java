package overcoming;

public class Robot implements Participant{

     int MAX_RUN_DIST;
     int MAX_JUMP_DIST;
    String name;
    int distance;

    public Robot(String name,int MAX_RUN_DIST, int MAX_JUMP_DIST){
        this.MAX_RUN_DIST = MAX_RUN_DIST;
        this.MAX_JUMP_DIST = MAX_JUMP_DIST;
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        this.distance = distance;
        if(distance < MAX_RUN_DIST){
            System.out.println(name+" преодалел препятствие беговая дорожка на дистанцию "+distance);
            return true;
        }else{
            System.out.println(name+" не преодалел препятствие беговая дорожка на дистанцию "+distance + ", пройдено " + MAX_RUN_DIST);
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        this.distance = distance;
        if(distance < MAX_JUMP_DIST){
            System.out.println(name+" преодалел препятствие стена на дистанцию "+distance);
            return true;
        }else{
            System.out.println(name+" не преодалел препятствие стена на дистанцию "+distance + ", пройдено " + MAX_JUMP_DIST);
            return false;
        }
    }
}
