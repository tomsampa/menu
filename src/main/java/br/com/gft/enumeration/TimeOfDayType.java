package br.com.gft.enumeration;

public enum TimeOfDayType {
	
	MORNING(1, "Manhã"), 
	NIGHT(2, "Noite"); 

    private Integer value;
    private String description;

    TimeOfDayType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer value() {
        return value;
    }
    
    public String description() {
        return description;
    }

    public static TimeOfDayType byValue(Integer value) {
        for (TimeOfDayType type : TimeOfDayType.values()) {
            if (type.value().equals(value)) {
                return type;
            }
        }
        return null;
    }
}


