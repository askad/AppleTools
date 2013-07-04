package yy.excelutil.common;

import java.util.Comparator;

import yy.excelutil.pojo.ArrivedPoJo;

public class ArrivedInfoComparator implements Comparator<ArrivedPoJo> {
    @Override
    public int compare(ArrivedPoJo object1, ArrivedPoJo object2) {
        return object1.getMbillNo().compareTo(object2.getMbillNo());
    }

}
