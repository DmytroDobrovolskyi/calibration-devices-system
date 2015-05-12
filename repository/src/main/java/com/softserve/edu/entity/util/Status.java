package com.softserve.edu.entity.util;

public enum Status {
    SENT("³���������"), RECEIVED("��������"), IN_PROGRESS("� ������ �������"), COMPLETED("���������"),
    NOT_FOUND("������ � ����� ����� �� ����");

    private String name;

    private Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
