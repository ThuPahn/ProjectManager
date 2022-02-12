package com.company;

public enum Category {
    HOUSEHOLD("Đồ gia đình"), FOOD("Thực phẩm"), FASHION("Thời trang");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
