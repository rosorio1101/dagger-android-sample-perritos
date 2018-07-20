package cl.gdgandroidstgo.simple_dagger_application.di.module;

import cl.gdgandroidstgo.simple_dagger_application.listBreed.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    public abstract MainActivity contributeMainActivity();
}
