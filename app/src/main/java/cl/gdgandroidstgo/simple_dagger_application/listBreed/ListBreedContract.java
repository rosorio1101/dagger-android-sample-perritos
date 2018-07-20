package cl.gdgandroidstgo.simple_dagger_application.listBreed;

import java.util.List;

import cl.gdgandroidstgo.simple_dagger_application.commons.BaseContract;

public interface ListBreedContract {
    interface View extends BaseContract.BaseView {
        void showBreedList(List<BreedViewModel> breeds);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBreeds();

        void stop();
    }
}
