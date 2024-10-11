package com.sprint1.be_java_hisp_w27_g04.repository.impl;

import com.sprint1.be_java_hisp_w27_g04.entity.User;
import lombok.Getter;

import java.util.Comparator;

@Getter
public enum UserComparator {
    NAME_DESC(Comparator.comparing(User::getName).reversed()),
    NAME_ASC(Comparator.comparing(User::getName));

    private final Comparator<User> comparator;

    UserComparator(Comparator<User> comparator) {
        this.comparator = comparator;
    }

}

