package com.example.todoapi.common;

public class Enums {
    public enum TodoStatus {
        TODO(1, "Todo"),
        DONE(2, "Done");

        private final int code;
        private final String value;

        TodoStatus(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public static TodoStatus findByCode(int code) {
            for (TodoStatus todoStatus : values()) {
                if (todoStatus.getCode() == code) {
                    return todoStatus;
                }
            }
            return null;
        }
    }

    public enum TodoCategory {
        HOME(1, "Home"),
        WORK(2, "Work"),
        Travel(3, "Travel");

        private final int code;
        private final String value;

        TodoCategory(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public static TodoCategory findByCode(int code) {
            for (TodoCategory todoCategory : values()) {
                if (todoCategory.getCode() == code) {
                    return todoCategory;
                }
            }
            return null;
        }
    }
}
