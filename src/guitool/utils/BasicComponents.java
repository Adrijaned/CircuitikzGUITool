package guitool.utils;

public enum BasicComponents {
    SHORT("short", ""),
    RESISTOR("european resistor", "R"),
    OPEN("open", ""),
    TGENERIC("tgeneric", ""),
    BATTERY("battery", ""),
    BATTERY1("battery1", ""),
    FUSE("fuse", ""),
    EMPTY_DIODE("empty diode", "D"),
    CAPACITOR("capacitor", "C"),
    CUTE_INDUCTOR("cute inductor", "L"), // AYAYA CUTE
    AMERICAN_INDUCTOR("american inductor", "L"),
    PUSH_BUTTON("push button", ""),
    DCV_SOURCE("european voltage source", "U"),
    DCC_SOURCE("european current source", "I"),
    A_METER("ammeter", ""),
    V_METER("voltmeter", ""),
    ISOURCESIN("isourcesin", ""),
    VSOURCESIN("vsourcesin", ""),
    GROUND("ground", ""),
    SGROUND("sground", ""),
    NGROUND("nground", ""),
    RGROUND("rground", ""),
    PGROUND("pground", ""),
    CGROUND("cground", ""),
    CLOSING_SW("closing switch", "S"),
    OPENING_SW("opening switch", "S");

    private final String name;
    private final String defaultLabel;

    BasicComponents(String name, String defaultLabel) {
        this.name = name;
        this.defaultLabel = defaultLabel;
    }

    public String getName() {
        return name;
    }

    public String getDefaultLabel() {
        return defaultLabel;
    }
}
