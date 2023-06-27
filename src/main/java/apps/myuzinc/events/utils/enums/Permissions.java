package apps.myuzinc.events.utils.enums;

public enum Permissions {
    PAYMENT_ADD("payment:add"),
    PAYMENT_INQUIRE("payment:inquire"),
    PAYMENT_MODIFY ("payment:modify"),
    PAYMENT_DELETE("payment:delete"),
    USER_ADD("user:add"),
    USER_INQUIRE("user:inquire"),
    USER_MODIFY ("user:modify"),
    USER_DELETE ("user:delete");

    public final String permission;

    Permissions(String value) {
        this.permission = value;
    }

    public String getPermission() {
        return permission;
    }
}
