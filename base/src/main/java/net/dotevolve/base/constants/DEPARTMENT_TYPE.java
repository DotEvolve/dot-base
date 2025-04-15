/*******************************************************************************
 * @Copyright (c) 2023 DotEvolve, All rights reserved
 * @author DotEvolve
 * @since 15/02/23, 9:45 am
 *
 *
 ******************************************************************************/

package net.dotevolve.base.constants;

public enum DEPARTMENT_TYPE {
    BOTTOM("1", "Bottom"),
    CUTTING("2", "Cutting"),
    FINISH("3", "Finish"),
    PACKAGING("4", "Packaging"),
    POLISH("5", "Polish"),
    UPPER("6", "Upper"),
    UNKNOWN("0", "Unknown");

    private String id;
    private String department;

    DEPARTMENT_TYPE(String id, String department) {
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
}
