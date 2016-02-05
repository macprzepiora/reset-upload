package org.vaadin.addon.mac.resetupload.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addon.mac.resetupload.ResetUploadExtension;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@Title("MyComponent Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "org.vaadin.addon.mac.resetupload.demo.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
    	Upload upload1 = new Upload();
    	final ResetUploadExtension extension = new ResetUploadExtension(upload1);
    	Button resetButton = new Button("Reset", new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				extension.resetUpload();
			}
		});
    	Upload upload2 = new Upload();

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();

        layout.addComponents(upload1, resetButton, upload2);
        setContent(layout);

    }

}
