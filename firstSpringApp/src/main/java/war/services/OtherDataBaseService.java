package war.services;

public class OtherDataBaseService implements DataBaseService {

    @Override
    public void printMessage() {
        System.out.println("Other service was injected");
    }

    @Override
    public void putData(){}
}