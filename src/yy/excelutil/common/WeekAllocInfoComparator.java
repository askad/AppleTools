package yy.excelutil.common;

import java.util.Comparator;

import yy.excelutil.pojo.WeekAllocInfoPoJo;

public class WeekAllocInfoComparator implements Comparator<WeekAllocInfoPoJo> {
    @Override
    public int compare(WeekAllocInfoPoJo object1, WeekAllocInfoPoJo object2) {
        return object1.getDate().compareTo(object2.getDate());
    }

}
