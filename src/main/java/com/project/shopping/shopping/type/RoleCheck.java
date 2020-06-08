package com.project.shopping.shopping.type;

import java.util.HashMap;
import java.util.Map;

public enum RoleCheck {

    admin(1), nonadmin(0);
    private static final Map<Integer, RoleCheck> Lookup = new HashMap<>();
    static {
        for (RoleCheck userStatus : RoleCheck.values()) {
            Lookup.put(userStatus.getCode(), userStatus);
        }
    }
    private final int code;

    private RoleCheck(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RoleCheck getEnum(final int code) {
        return Lookup.get(code);
    }

}
