package models;

public class Order {
	private String editionCode;
	private String addonOfferingCode;
	private String pricingDuration;
	private String[] customAttributes;
	Items[] items;
	
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public String[] getCustomAttributes() {
		return customAttributes;
	}
	public void setCustomAttributes(String[] customAttributes) {
		this.customAttributes = customAttributes;
	}
	public Items[] getItems() {
		return items;
	}
	public void setItems(Items[] items) {
		this.items = items;
	}
	
}
