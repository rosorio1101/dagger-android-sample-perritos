package cl.gdgandroidstgo.simple_dagger_application.commons;

public interface BaseContract {
    interface BaseView {
        void showLoading();
        void hideLoading();
    }

    interface BasePresenter<T extends BaseView> {
        void attachView(T view);
        void detachView();
    }
}
