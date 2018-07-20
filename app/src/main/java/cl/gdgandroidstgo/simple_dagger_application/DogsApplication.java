package cl.gdgandroidstgo.simple_dagger_application;

import cl.gdgandroidstgo.simple_dagger_application.di.DaggerDogsAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class DogsApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerDogsAppComponent.builder().create(this);
    }
}
