package org.orienteer.tiny_chat.widgets;

import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OSchema;
import com.orientechnologies.orient.core.metadata.schema.OType;

import ru.ydn.wicket.wicketorientdb.AbstractDataInstallator;
import ru.ydn.wicket.wicketorientdb.OrientDbWebApplication;

public class TinyChatWidgetInstallator extends AbstractDataInstallator {

	@Override
	protected void installData(OrientDbWebApplication arg0, ODatabaseDocument arg1) {

		OSchema schema = arg1.getMetadata().getSchema();
		if (! schema.existsClass("Message")){
			OClass mess = schema.createClass("Message");
			mess.createProperty("messageText", OType.STRING);
		}
	}

}
