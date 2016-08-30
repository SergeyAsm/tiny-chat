package org.orienteer.tinychat;

import org.orienteer.core.OrienteerWebApplication;
import org.orienteer.core.module.AbstractOrienteerModule;
import org.orienteer.core.util.OSchemaHelper;

import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.metadata.schema.OType;

public class DataModel extends AbstractOrienteerModule{

	protected DataModel() {
		super("tiny-chat", 1);
	}
	
	
	@Override
	public ODocument onInstall(OrienteerWebApplication app, ODatabaseDocument db) {
		super.onInstall(app, db);
		OSchemaHelper helper = OSchemaHelper.bind(db);

		//Install data model
		helper.oClass("Message").oProperty("messageText", OType.STRING);
		
		return null;
	}
	
	
	@Override
	public void onUpdate(OrienteerWebApplication app, ODatabaseDocument db, int oldVersion, int newVersion) {
		super.onUpdate(app, db, oldVersion, newVersion);
		OSchemaHelper helper = OSchemaHelper.bind(db);
		helper.oClass("Message").oProperty("messageText", OType.STRING);
	}
	
	
	@Override
	public void onInitialize(OrienteerWebApplication app, ODatabaseDocument db) {
		super.onInitialize(app, db);
		app.registerWidgets("org.orienteer.tinychat.widgets");
	}
	
	
	@Override
	public void onDestroy(OrienteerWebApplication app, ODatabaseDocument db) {
		app.unregisterWidgets("org.orienteer.tinychat.widgets");
		super.onDestroy(app, db);
	}
	
}
