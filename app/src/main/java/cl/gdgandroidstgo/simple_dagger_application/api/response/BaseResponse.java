package cl.gdgandroidstgo.simple_dagger_application.api.response;

public abstract class BaseResponse<T> {
    private final String status;
    private final T message;

    public BaseResponse(String status, T message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public T getMessage() {
        return message;
    }
}
