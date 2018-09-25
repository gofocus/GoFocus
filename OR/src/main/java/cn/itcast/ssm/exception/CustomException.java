package cn.itcast.ssm.exception;

/**
 * Created by gofocus on 2017/3/2813:23.
 */
public class CustomException extends Exception {


    //异常信息
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
