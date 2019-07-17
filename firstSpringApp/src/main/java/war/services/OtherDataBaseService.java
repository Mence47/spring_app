package war.services;

import war.model.*;

public class OtherDataBaseService implements DataBaseService {

    @Override
    public void printMessage() {
        System.out.println("Other service was injected");
    }

    @Override
    public UserDto putData(){ return null;}
}