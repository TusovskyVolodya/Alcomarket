package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Kind;
import ua.service.KindService;

public class KindEditor  extends PropertyEditorSupport {
	
	private final KindService kindService;

	public KindEditor(KindService kindService) { 
		this.kindService = kindService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Kind kind = kindService.findOne(Integer.valueOf(text));
		setValue(kind);
	}  

}
