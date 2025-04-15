/*******************************************************************************
 * @Copyright (c) 2023 DotEvolve, All rights reserved
 * @author DotEvolve
 * @since 02/02/23, 2:29 am
 *
 *
 ******************************************************************************/

package net.dotevolve.base.constants;

import static net.dotevolve.base.constants.CONFIG_ID.ListNames.ARTICLES_LIST_NAME;
import static net.dotevolve.base.constants.CONFIG_ID.ListNames.COLORS_LIST_NAME;
import static net.dotevolve.base.constants.CONFIG_ID.ListNames.CUSTOMERS_LIST_NAME;
import static net.dotevolve.base.constants.CONFIG_ID.ListNames.MATERIALS_LIST_NAME;
import static net.dotevolve.base.constants.CONFIG_ID.ListNames.SOLES_LIST_NAME;
import static net.dotevolve.base.constants.CONFIG_ID.ListNames.WORKERS_LIST_NAME;

public enum CONFIG_ID {
    ARTICLES_LIST(ARTICLES_LIST_NAME),
    COLORS_LIST(COLORS_LIST_NAME),
    MATERIALS_LIST(MATERIALS_LIST_NAME),
    SOLES_LIST(SOLES_LIST_NAME),
    WORKERS_LIST(WORKERS_LIST_NAME),
    CUSTOMERS_LIST(CUSTOMERS_LIST_NAME);

    private final String value;

    CONFIG_ID(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CONFIG_ID{" +
                "value='" + value + '\'' +
                '}';
    }

    enum ListNames {
        ;
        static final String ARTICLES_LIST_NAME = "articlesList";
        static final String COLORS_LIST_NAME = "colorsList";
        static final String MATERIALS_LIST_NAME = "materialsList";
        static final String SOLES_LIST_NAME = "solesList";
        static final String WORKERS_LIST_NAME = "workersList";
        static final String CUSTOMERS_LIST_NAME = "customersList";
    }
}