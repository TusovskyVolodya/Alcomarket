package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.GiftBox;
import ua.service.GiftBoxService;

public class GiftBoxEditor extends PropertyEditorSupport {
	
	private final GiftBoxService giftBoxService;

	public GiftBoxEditor(GiftBoxService giftBoxService) { 
		this.giftBoxService = giftBoxService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		GiftBox giftBox = giftBoxService.findOne(Integer.valueOf(text));
		setValue(giftBox);
	}  

}
