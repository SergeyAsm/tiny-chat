package org.orienteer.tiny_chat.widgets;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.orienteer.core.component.FAIcon;
import org.orienteer.core.component.FAIconType;
import org.orienteer.core.widget.AbstractWidget;
import org.orienteer.core.widget.Widget;

import com.orientechnologies.orient.core.record.impl.ODocument;

import ru.ydn.wicket.wicketorientdb.model.ODocumentPropertyModel;
import ru.ydn.wicket.wicketorientdb.model.OQueryModel;


	
@Widget(domain="schema", tab="Chat", id="tiny-chat-widget", autoEnable=true)
public class TinyChatWidget extends AbstractWidget<Void> {

    public TinyChatWidget(String id, IModel<Void> model, IModel<ODocument> widgetDocumentModel) {
        super(id, model, widgetDocumentModel);
        
    	ListView<ODocument> messagesView;
		add( messagesView = new ListView<ODocument>("messages", new OQueryModel<ODocument>("select from Message")) {
			@Override
			protected void populateItem(ListItem<ODocument> item) {
				item.add(new Label("messageText", new ODocumentPropertyModel<String>(item.getModel(), "messageText")));
			}
		});
		messagesView.setReuseItems(true);
    	
		Form<String> form;
		add(form = new Form<String>("messageForm"){
    	    @Override
    	    protected void onSubmit() {
    			ODocument doc = new ODocument("Message");
    			doc.field( "messageText", get("messageTextInput").getDefaultModelObject().toString() );
    			doc.save();

    			get("messageTextInput").getDefaultModel().setObject(null);
    	    }	

    	});
		form.add(new TextArea<String>("messageTextInput", new Model<String>()));        
    }

    @Override
    protected FAIcon newIcon(String id) {
        return new FAIcon(id, FAIconType.exclamation);
    }

    @Override
    protected IModel<String> getDefaultTitleModel() {
        return Model.of("Chat with other users");
    }

}

