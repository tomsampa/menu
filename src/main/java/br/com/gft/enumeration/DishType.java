package br.com.gft.enumeration;

public enum DishType {
	
	ENTREE(1), 
	SIDE(2), 
	DRINK(3), 
	DESSERT(4);

    private Integer value;

    DishType(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public static DishType byValue(Integer value) {
        for (DishType type : DishType.values()) {
            if (type.value().equals(value)) {
                return type;
            }
        }
        return null;
    }

}
