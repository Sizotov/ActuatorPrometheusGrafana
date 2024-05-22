package com.example.homeWorkSDJ.model;

public enum TaskStatus {
    IN_PROGRESS, COMPLETED, NOT_STARTED;

    public String getStatusWeb() {
        if (this.equals(TaskStatus.IN_PROGRESS)) {
            return "Выполняется";
        } else if (this.equals(TaskStatus.COMPLETED)) {
            return "Завершен";
        } else if (this.equals(TaskStatus.NOT_STARTED)){
            return "Не начался";
        }
        else {
            return "Не известен";
        }
    }
}

