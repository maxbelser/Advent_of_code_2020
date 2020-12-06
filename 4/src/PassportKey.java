
public enum PassportKey {
	BYR, IYR, EYR, HGT, HCL, ECL, PID, CID;

	public static <T extends Enum<?>> T searchEnum(Class<T> enumeration,
	        String search) {
	    for (T each : enumeration.getEnumConstants()) {
	        if (each.name().compareToIgnoreCase(search) == 0) {
	            return each;
	        }
	    }
	    throw new IllegalArgumentException("No legal Enum found");
	}
	

}
