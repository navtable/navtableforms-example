package es.icarto.gvsig.navtableformsexample;

import com.iver.andami.PluginServices;
import com.iver.andami.plugins.Extension;
import com.iver.cit.gvsig.fmap.layers.FLyrVect;

import es.icarto.gvsig.navtableforms.ormlite.ORMLite;
import es.icarto.gvsig.navtableforms.utils.TOCLayerManager;

public class Example1Extension extends Extension {

    private FLyrVect layer;

    public void execute(String actionCommand) {
	layer = getLayerFromTOC();
	Example1Form dialog = new Example1Form(layer);
	if (dialog.init()) {
	    PluginServices.getMDIManager().addWindow(dialog);
	}
    }

    private FLyrVect getLayerFromTOC() {
	String layerName = ORMLite
		.getDataBaseObject(Preferences.XMLDATAFILE_PATH)
		.getTable("Example 1").getTableName();
	TOCLayerManager toc = new TOCLayerManager();
	return toc.getLayerByName(layerName);
    }

    protected void registerIcons() {
	PluginServices.getIconTheme().registerDefault(
		"example1-ntforms",
		this.getClass().getClassLoader()
		.getResource("images/example1.png"));
    }

    public void initialize() {
	registerIcons();
    }

    public boolean isEnabled() {
	if (isExampleDataSetLoaded()) {
	    return true;
	}
	return false;
    }

    private boolean isExampleDataSetLoaded() {
	if (getLayerFromTOC() == null) {
	    return false;
	}
	return true;
    }

    public boolean isVisible() {
	return true;
    }

}
