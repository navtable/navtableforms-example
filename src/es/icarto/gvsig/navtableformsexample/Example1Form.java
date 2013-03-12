package es.icarto.gvsig.navtableformsexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.iver.cit.gvsig.fmap.layers.FLyrVect;
import com.jeta.forms.components.panel.FormPanel;

import es.icarto.gvsig.navtableforms.AbstractForm;

@SuppressWarnings("serial")
public class Example1Form extends AbstractForm {

    public static final String ABEILLE_FILENAME = "exampleform1.xml";
    private FormPanel form;
    private JCheckBox chb;
    private JTextField cmp;

    public Example1Form(FLyrVect layer) {
	super(layer);
	initWindow();
    }

    private void initWindow() {
	viewInfo.setHeight(350);
	viewInfo.setWidth(450);
	viewInfo.setTitle("Example 1");
    }

    @Override
    public FormPanel getFormBody() {
	if (form == null) {
	    form = new FormPanel(Example1Form.ABEILLE_FILENAME);
	}
	return form;
    }

    @Override
    public String getXMLPath() {
	return Preferences.XMLDATAFILE_PATH;
    }

    @Override
    public Logger getLoggerName() {
	return Logger.getLogger(this.getClass().getName());
    }

    @Override
    protected void setListeners() {
	super.setListeners();

	HashMap<String, JComponent> widgets = getWidgetComponents();
    }

    @Override
    protected void removeListeners() {
	super.removeListeners();
    }

    @Override
    protected void fillSpecificValues() {
    }

}
