package com.sample.extensions;

import akka.actor.*;

/**
 * Created by sande on 6/4/2017.
 */
public class Settings extends AbstractExtensionId<SettingsImpl> implements ExtensionIdProvider{

    public final static Settings SettingsProvider = new Settings();

    private Settings() {}

    public Settings lookup() {
        return Settings.SettingsProvider;
    }

    public SettingsImpl createExtension(ExtendedActorSystem system) {
        return new SettingsImpl(system.settings().config());
    }
}
