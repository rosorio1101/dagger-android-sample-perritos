package cl.gdgandroidstgo.simple_dagger_application.commons;

import java.lang.ref.WeakReference;

public abstract class BaseAbstractPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    private WeakReference<T> view;

    @Override
    public void attachView(T view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.view.clear();
    }

    protected T getView() {
        return view.get();
    }
}
