package ua.editor;

import java.beans.PropertyEditorSupport;

public class ItemFormEditor extends PropertyEditorSupport {
	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer itemForm = (Integer.valueOf(text));
		setValue(itemForm);
	}  
}


