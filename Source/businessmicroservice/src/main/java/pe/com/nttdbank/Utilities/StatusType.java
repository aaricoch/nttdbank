package pe.com.nttdbank.Utilities;

public enum StatusType {
    Inactive(1),
    Active(0);

    public final int value;

    private StatusType(int val) {
        this.value = val;
    }
}
