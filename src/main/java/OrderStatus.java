public enum OrderStatus {
    PROCESSING("Processing"),
    IN_DELIVERY("In_Delivery"),
    COMPLETED("Completed");

    private final String value;

    OrderStatus(String value){
        this.value = value;
    }
}
