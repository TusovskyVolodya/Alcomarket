package ua.dto.form;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ItemFilter {
	
	
	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");

	private String search = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private Integer max;
	
	private Integer min;
	
	private List<Integer> brandIds = new ArrayList<>();
	
	private List<Integer> countryIds = new ArrayList<>();
	
	private List<Integer> categoryIds = new ArrayList<>();
	
	private List<Integer> giftBoxIds = new ArrayList<>();
	
	private List<Integer> kindIds = new ArrayList<>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(PEATTERN.matcher(maxPrice).matches())max = Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(PEATTERN.matcher(minPrice).matches())min = Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public List<Integer> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Integer> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Integer> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Integer> countryIds) {
		this.countryIds = countryIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getGiftBoxIds() {
		return giftBoxIds;
	}

	public void setGiftBoxIds(List<Integer> giftBoxIds) {
		this.giftBoxIds = giftBoxIds;
	}

	public List<Integer> getKindIds() {
		return kindIds;
	}

	public void setKindIds(List<Integer> kindIds) {
		this.kindIds = kindIds;
	}

	public static Pattern getPeattern() {
		return PEATTERN;
	}
	
	
	


	

}
