package org.orienteer.tiny_chat;

import org.orienteer.core.OrienteerWebApplication;
import org.orienteer.core.module.PerspectivesModule;
import org.orienteer.tiny_chat.widgets.TinyChatWidgetInstallator;

public class MyWebApplication extends OrienteerWebApplication
{
	@Override
	public void init()
	{
		super.init();
		mountPages("org.orienteer.tiny_chat.web");
		registerModule(DataModel.class);
		registerWidgets("org.orienteer.tiny_chat.widgets");
		getApplicationListeners().add(new TinyChatWidgetInstallator());

	}
	
}
