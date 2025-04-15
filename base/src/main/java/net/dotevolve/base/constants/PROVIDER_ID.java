/*******************************************************************************
 * @Copyright (c) 2023 DotEvolve, All rights reserved
 * @author DotEvolve
 * @since 02/02/23, 2:29 am
 *
 *
 ******************************************************************************/

package net.dotevolve.base.constants;

public enum PROVIDER_ID {
    MASCOT_FOOTWEAR("mascot-footwear"),
    TEST("123");

    private final String value;

    PROVIDER_ID(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
