package com.nadex.bussroute.service.validator;

import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class RouteValidator implements DataValidator{
    private LinkedHashSet<Integer> routesIds = new LinkedHashSet<>();

    @Override
    public boolean isValid(StringBuilder builder) {
        int indexFirstSpase = builder.indexOf(" ");
        if (builder.length() < 3 || indexFirstSpase == -1) return false;
        String id = builder.substring(0,indexFirstSpase);
        if (builder.substring(indexFirstSpase + 1, builder.length()).length() < 1) return false;
        if (!id.matches("\\d+")) return false;
        if(Long.parseLong(id) > Integer.MAX_VALUE || Integer.parseInt(id) <= 0) return false;
        int num = Integer.parseInt(id);
        if (routesIds.contains(num)) return false;
        routesIds.add(num);
        return true;
    }
}
