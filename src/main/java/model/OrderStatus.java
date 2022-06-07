package model;

public enum OrderStatus {
    REQUEST("注文申請"),
    COMPLETE("注文完了"),
    CANCEL("注文キャンセル");

    private String name;

    OrderStatus(String name){
        this.name = name;
    }
}
