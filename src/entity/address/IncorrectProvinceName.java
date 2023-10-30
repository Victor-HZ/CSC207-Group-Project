package entity.address;

public class IncorrectProvinceName extends Exception{
    IncorrectProvinceName(String province){
        super(province + "not a Canadian Province");
    }
}
