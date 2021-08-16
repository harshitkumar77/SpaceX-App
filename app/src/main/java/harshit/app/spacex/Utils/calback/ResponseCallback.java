package harshit.app.spacex.Utils.calback;

public interface ResponseCallback {
    void onSuccessful();
    void onFailed(String error);
}
