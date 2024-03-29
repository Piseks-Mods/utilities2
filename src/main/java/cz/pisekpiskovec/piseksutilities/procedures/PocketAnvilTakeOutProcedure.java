package cz.pisekpiskovec.piseksutilities.procedures;

import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

import cz.pisekpiskovec.piseksutilities.PiseksUtilitiesIiMod;

public class PocketAnvilTakeOutProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				PiseksUtilitiesIiMod.LOGGER.warn("Failed to load dependency guistate for procedure PocketAnvilTakeOut!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:itemRenameField");
			if (_tf != null) {
				_tf.setText("");
			}
		}
	}
}
