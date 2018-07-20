package cl.gdgandroidstgo.simple_dagger_application.di;

import javax.inject.Singleton;

import cl.gdgandroidstgo.simple_dagger_application.DogsApplication;
import cl.gdgandroidstgo.simple_dagger_application.di.module.ActivityModule;
import cl.gdgandroidstgo.simple_dagger_application.di.module.NetworkModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                NetworkModule.class,
                ActivityModule.class
        }
)
public interface DogsAppComponent extends AndroidInjector<DogsApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DogsApplication> {

    }
}
