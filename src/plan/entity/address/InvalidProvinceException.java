package plan.entity.address;

public class InvalidProvinceException extends Exception{
    InvalidProvinceException(String province){
        super(province + "not a Canadian Province");
    }
}
